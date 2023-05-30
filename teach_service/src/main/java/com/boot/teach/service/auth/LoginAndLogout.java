package com.boot.teach.service.auth;


import com.boot.teach.common.response.ServerResponseEntity;
import com.boot.teach.dto.auth.UserDto;
import org.apache.tomcat.websocket.AuthenticationException;


public interface LoginAndLogout {
    ServerResponseEntity login(UserDto userDto) throws AuthenticationException;

    ServerResponseEntity logout();
}
