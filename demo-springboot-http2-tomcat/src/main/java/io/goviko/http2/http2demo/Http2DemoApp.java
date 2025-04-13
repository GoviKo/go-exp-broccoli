package io.goviko.http2.http2demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Http2DemoApp {

    public static void main(String[] params){
        new SpringApplicationBuilder(Http2DemoApp.class)
            .run(params);
    }    
}
