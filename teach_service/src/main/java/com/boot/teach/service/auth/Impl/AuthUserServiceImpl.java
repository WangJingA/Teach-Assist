package com.boot.teach.service.auth.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.teach.dao.auth.AuthUserMapper;
import com.boot.teach.model.auth.TeachUser;
import com.boot.teach.service.auth.AuthUserService;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, TeachUser> implements AuthUserService {

    @Autowired
    AuthUserMapper userMapper;
    @Override
    public TeachUser getUserByUsername(String username) throws AuthenticationException {
        TeachUser user = userMapper.selectOne(new QueryWrapper<TeachUser>().lambda().eq(TeachUser::getUserAccount, username));
        if (Objects.isNull(user)){
            throw new AuthenticationException("用户信息不存在");
        }
        return user;
    }
}
