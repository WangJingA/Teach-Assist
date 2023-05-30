package com.boot.teach.common.exception;

import cn.hutool.json.JSONUtil;
import com.boot.teach.common.util.AuthExceptionUtil;
import com.boot.teach.common.util.WebUtils;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 自定义授权异常处理类
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, org.springframework.security.core.AuthenticationException e) throws IOException, ServletException {
        WebUtils.rednerString(httpServletResponse, JSONUtil.toJsonStr(AuthExceptionUtil.getErrMsgByExceptionType(e)));
    }
}
