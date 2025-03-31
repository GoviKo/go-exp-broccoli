package io.goviko.spring.guicedemo;

import com.google.inject.Singleton;

import static java.lang.String.format;

@Singleton
public class AppServiceImpl implements AppService {

    @Override
    public String message() {
        return format("%d %s  ::  lorem ipsum", Thread.currentThread().getId(), 
            Thread.currentThread().getName());
    }
}

