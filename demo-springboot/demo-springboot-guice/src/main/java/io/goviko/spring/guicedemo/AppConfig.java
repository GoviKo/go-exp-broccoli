package io.goviko.spring.guicedemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.guice.annotation.EnableGuiceModules;

@EnableGuiceModules
@Configuration
public class AppConfig {
    
    @Bean
    public static AppModule appServiceModule() {
        return new AppModule();
    }

}
