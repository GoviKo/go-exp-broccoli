package io.goviko.interceptor.interceptordemo.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import io.goviko.interceptor.interceptordemo.interceptor.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoggingInterceptor loggingInterceptor;
    private final MetricsInterceptor metricsInterceptor;

    @Autowired
    public WebConfig(LoggingInterceptor theLoggingInterceptor,
                     MetricsInterceptor theMetricsInterceptor) {
        loggingInterceptor = theLoggingInterceptor;
        metricsInterceptor = theMetricsInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor);
        registry.addInterceptor(metricsInterceptor);
    }
}