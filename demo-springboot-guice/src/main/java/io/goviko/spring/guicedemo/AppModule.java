package io.goviko.spring.guicedemo;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
 
    @Override
    protected void configure() {
        bind(AppService.class).to(AppServiceImpl.class);
    }
}
