package com.team_28.StackOverFlow.jwt.filter;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        ErrorResponse errorResponse = new ErrorResponse(403, "접근 권한이 없습니다.");
//        response.setContentType(APPLICATION_JSON_VALUE);
//        response.setCharacterEncoding("utf-8");
//        new ObjectMapper().writeValue(response.getWriter(), errorResponse);
//        throw new CustomLogicException(ExceptionCode.SC_FORBIDDEN);
    }
}
