package io.goviko.interceptor.interceptordemo.interceptor;

import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.*;
import java.time.Instant;

@Component
public class ApiValidationInterceptor implements HandlerInterceptor {

    final static Logger logger = LoggerFactory.getLogger(ApiValidationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        response.addHeader("x-timestamp", Instant.now().toString());
        response.addHeader("x-app", "morel muspi");

        logger.info("[preHandle][{}][{}] {}", request, request.getMethod(), request.getRequestURI());
        if (null == request.getHeader("X-API-KEY")) {
            logger.info("Missing API KEY header");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        if(!isValidApiKey(request.getHeader("X-API-KEY"))) {
            logger.info("No Valid API KEY");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
        return true;
    }

    private boolean isValidApiKey(String key) {
        return "zxcvuiopghjklbnmasdfytrewq".equals(key);  // rigorous API key check
    }
}
