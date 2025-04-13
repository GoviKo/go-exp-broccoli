package io.goviko.aspect.aspectdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AspectDemoApp {

    public static void main(String[] params){
        new SpringApplicationBuilder(AspectDemoApp.class)
            .run(params);
    }
}
