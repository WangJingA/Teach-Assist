package com.boot.teach.web.controllers.login;

import com.boot.teach.common.response.ServerResponseEntity;
import com.boot.teach.dto.auth.UserDto;
import com.boot.teach.service.auth.LoginAndLogout;
import com.boot.teach.vo.auth.UserVo;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginAndLogout loginAndLogout;
    @Autowired
    MapperFactory mapperFactory;
    @PostMapping("userLogin")
    public ServerResponseEntity userLogin(UserVo userVo) throws AuthenticationException {
        mapperFactory.classMap(UserDto.class, UserVo.class);
        UserDto userDto = mapperFactory.getMapperFacade().map(userVo, UserDto.class);
        return loginAndLogout.login(userDto);
    }
}
