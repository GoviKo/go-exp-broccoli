package io.goviko.interceptor.interceptordemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoInterceptorApp {

    public static void main(String[] params){
        new SpringApplicationBuilder(DemoInterceptorApp.class)
            .run(params);
    }
}
