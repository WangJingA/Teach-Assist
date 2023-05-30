package com.boot.teach.common.exception;

import cn.hutool.json.JSONUtil;
import com.boot.teach.common.util.AuthExceptionUtil;
import com.boot.teach.common.util.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义授权失败实现类返回异常信息
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        WebUtils.rednerString( httpServletResponse, JSONUtil.toJsonStr(AuthExceptionUtil.getErrMsgByExceptionType(e)));
    }
}
