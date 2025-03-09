package io.goviko.profile.profiledemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoProfileApp {

    public static void main(String[] params){
        new SpringApplicationBuilder(DemoProfileApp.class)
            .run(params);
    }
}
