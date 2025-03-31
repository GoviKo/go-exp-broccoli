package io.goviko.spring.guicedemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GuiceSpringApp {

    public static void main(String[] params) {
        new SpringApplicationBuilder(GuiceSpringApp.class)
            .run(params);
    }
}
