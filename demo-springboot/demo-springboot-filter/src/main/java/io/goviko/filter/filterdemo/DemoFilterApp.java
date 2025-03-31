package io.goviko.filter.filterdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoFilterApp {

    public static void main(String[] params) {
        new SpringApplicationBuilder(DemoFilterApp.class)
                .run(params);
    }
}
