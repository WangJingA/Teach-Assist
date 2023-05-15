package com.boot.teach.common.util;

import jakarta.servlet.http.HttpServletResponse;

/**
 * web响应封装
 */
public class WebUtils {
    public static String rednerString(HttpServletResponse response, String content) {
        try{
            response.setStatus(200);
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(content);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
