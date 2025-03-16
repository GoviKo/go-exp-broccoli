package io.goviko.profile.profiledemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController{

    @Autowired
    AppService appService;

    @GetMapping("/status")
    public String status(){
        return appService.message();
    }
}
