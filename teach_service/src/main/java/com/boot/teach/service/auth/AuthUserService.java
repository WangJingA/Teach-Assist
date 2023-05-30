package com.boot.teach.service.auth;


import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.teach.model.auth.TeachUser;
import org.apache.tomcat.websocket.AuthenticationException;

public interface AuthUserService extends IService<TeachUser> {
    TeachUser getUserByUsername(String username) throws AuthenticationException;
}
