package io.goviko.interceptor.interceptordemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.goviko.interceptor.interceptordemo.service.*;

@RestController
public class AppController{

    @Autowired
    AppService appService;

    @GetMapping("/message")
    public String message(){
        return appService.message();
    }
}
