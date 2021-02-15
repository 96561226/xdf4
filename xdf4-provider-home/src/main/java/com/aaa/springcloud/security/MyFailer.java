package com.aaa.springcloud.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyFailer implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ObjectMapper objectMapper = new ObjectMapper();
        //用来进行认证通过后返回的处理
        Map map= new HashMap();
        map.put("msg","failer");
        map.put("code",201);
        String result = objectMapper.writeValueAsString(map);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().print(result);
    }
}
