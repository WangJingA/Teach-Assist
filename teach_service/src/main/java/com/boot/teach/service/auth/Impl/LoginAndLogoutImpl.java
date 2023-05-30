package com.boot.teach.service.auth.Impl;

import com.boot.teach.common.constance.ExceptionMessageConstance;
import com.boot.teach.common.constance.ExcutionLogConstance;
import com.boot.teach.common.response.ResponseEnum;
import com.boot.teach.common.response.ServerResponseEntity;
import com.boot.teach.common.security.UserDetail;
import com.boot.teach.common.util.JWTUtils;
import com.boot.teach.common.util.RedisUtil;
import com.boot.teach.dto.auth.UserDto;
import com.boot.teach.service.auth.LoginAndLogout;
import org.apache.tomcat.websocket.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * security登录流程简介
 * --> 用户提交用户名和密码
 * --> 经过AbstractAuthenticationOnProcessingFilter的实现类 usernameAndPasswordAuthenticationFilter(封装用户信息为Authentication对象)
 * -> 调用AuthenticationManager的实现类（ProvideManager）的authenticate方法
 * -> 调用AbstractUserDetailAuthenticationProvide 的实现类（DaoAuthenticationProvide）的 authenticate方法
 * -> 调用UserDetailService的实现类的InMemoryUserDetailManager的LoadUserByUserName 进行用户信息查询，在InMemoryUserDetailManager的内存中查询用户权限
 * -> 将用户信息和权限封装成UserDetail 返回给DaoAuthenticationProvide ，通过PasswordEncoder比对用户登录密码和UserDetail中的密码是否一致
 * -> 比对通过将用户权限信息设置到Authentication对象中，返回给UsernameAndPasswordAuthenticationFilter保存到SecurityContextHolder中
 * -> 后续其他过滤器从SecurityContextHolder中获取用户信息
 */
@Service
public class LoginAndLogoutImpl implements LoginAndLogout {

    Logger logger = LoggerFactory.getLogger(LoginAndLogoutImpl.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public ServerResponseEntity login(UserDto userDto) throws AuthenticationException {
        String moduleName = "LoginAndLogoutImpl-login";
        long startTime = System.currentTimeMillis();
        logger.info(String.format(ExcutionLogConstance.ENTER_MODULE_PRINT,moduleName));
        logger.info(String.format(ExcutionLogConstance.MODULE_PARAM_PRINT,moduleName,userDto));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (userDto.getUserAccount(),userDto.getUserPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)){
            throw  new AuthenticationException(ExceptionMessageConstance.USER_NO_AUTHENCATION);
        }
        UserDetail userDetail = (UserDetail)authenticate.getPrincipal();
        //获取用户id
        String userId = userDetail.getUserModel().getUuid();
        //获取用户账号
        String userAccount = userDetail.getUserModel().getUserAccount();
        //获取token
        String token = JWTUtils.getToken(userId, userAccount);
        //resultMap
        Map<String,Object> resultMap = new HashMap<>();
        //将token存进返回中
        resultMap.put("token",token);
        resultMap.put("user",userDetail);
        //将用户信息存放进redis中,键为login+uuid
//        redisUtil.set("login:"+userId,userDetail);
        logger.info(String.format(ExcutionLogConstance.EXCUTION_MODULE_PRINT,moduleName,System.currentTimeMillis()-startTime));
        return ServerResponseEntity.success(ResponseEnum.OK.value(),ResponseEnum.OK.getMsg(),resultMap);
    }

    @Override
    public ServerResponseEntity logout() {
        String moduleName = "LoginAndLogoutImpl-logout";
        long startTime = System.currentTimeMillis();
        logger.info(String.format(ExcutionLogConstance.ENTER_MODULE_PRINT,moduleName));
        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUserKey = "login:"+userDetail.getUserModel().getUuid();
        redisUtil.del(loginUserKey);
        logger.info(String.format(ExcutionLogConstance.EXCUTION_MODULE_PRINT,moduleName,System.currentTimeMillis()-startTime));
        return ServerResponseEntity.success();
    }
}
