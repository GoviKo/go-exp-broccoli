package io.goviko.interceptor.interceptordemo.interceptor;

import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.*;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    final static Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, 
                             HttpServletResponse response,
                             Object handler) {
        logger.info("[preHandle][{}][{}] {}", request, request.getMethod(), request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                            HttpServletResponse response,
                            Object handler,
                            ModelAndView modelAndView) throws Exception {
        logger.info("[postHandle][{}]  {}", request, response.getStatus());
    }
}
