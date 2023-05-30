package com.boot.teach.common.util;

import com.boot.teach.common.response.ResponseEnum;
import com.boot.teach.common.response.ServerResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.csrf.CsrfException;


/**
 * 认证异常工具类
 */
public class AuthExceptionUtil {
    public static ServerResponseEntity getErrMsgByExceptionType(AuthenticationException e){
        if (e instanceof LockedException) {
            return  ServerResponseEntity.fail(ResponseEnum.ACCOUNT_LOCKED);
        } else if (e instanceof CredentialsExpiredException) {
            return  ServerResponseEntity.fail(ResponseEnum.CREDENTIALS_EXPIRE);
        }else if (e instanceof InsufficientAuthenticationException) {
            return ServerResponseEntity.fail(ResponseEnum.INSUFFICIENT_AUTHENTICATION);
        } else if (e instanceof AccountExpiredException) {
           return ServerResponseEntity.fail(ResponseEnum.ACCOUNT_EXPIRE);
        } else if (e instanceof DisabledException) {
           return ServerResponseEntity.fail(ResponseEnum.ACCOUNT_DISABLE);
        } else if (e instanceof BadCredentialsException) {
           return  ServerResponseEntity.fail(ResponseEnum.CREDENTIALS_EXPIRE);
        }else if (e instanceof AuthenticationServiceException) {
            return ServerResponseEntity.fail(ResponseEnum.AUTHENTICATION_EXCEPTION);
        }
        return ServerResponseEntity.fail(ResponseEnum.EXCEPTION);
    }

    public static ServerResponseEntity getErrMsgByExceptionType(AccessDeniedException e) {
        if (e instanceof CsrfException) {
           return ServerResponseEntity.fail(ResponseEnum.CRSF_EXCEPTION);
        } else if (e instanceof org.springframework.security.web.csrf.CsrfException) {
            return ServerResponseEntity.fail(ResponseEnum.CRSF_EXCEPTION);
        } else if (e instanceof AuthorizationServiceException) {
            return ServerResponseEntity.fail(ResponseEnum.AUTHENTICATION_SERVICE_EXCEPTION);
        }else if (e instanceof AccessDeniedException) {
            return ServerResponseEntity.fail(ResponseEnum.ACCESS_DENIED_EXCEPTION);
        }
        return ServerResponseEntity.fail(ResponseEnum.EXCEPTION);
    }
}
