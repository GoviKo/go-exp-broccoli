package io.goviko.graphql.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BookGraphQLApp {

    public static void main(String[] params) {
        new SpringApplicationBuilder(BookGraphQLApp.class)
                .run(params);
    }
}
