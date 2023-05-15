package com.boot.teach.common.exception;

/**
 * 认证异常封装类
 */
public class AuthenticationException extends org.springframework.security.core.AuthenticationException {

    public AuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public AuthenticationException(String msg) {
        super(msg);
    }
}
