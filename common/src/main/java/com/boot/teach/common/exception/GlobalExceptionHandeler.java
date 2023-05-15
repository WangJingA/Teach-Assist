package com.boot.teach.common.exception;

import com.boot.teach.common.response.ResponseEnum;
import com.boot.teach.common.response.ServerResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandeler {
    @ExceptionHandler(AuthenticationException.class)
    public ServerResponseEntity operationError(AuthenticationException e){
        return ServerResponseEntity.fail(ResponseEnum.AUTHENTICATION_EXCEPTION,e.getMessage());
    }
}
