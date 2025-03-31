package io.goviko.aspect.aspectdemo;

import io.goviko.aspect.aspectdemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    AppService appService;

    @GetMapping("/lorem")
    public String lorem(){
        return appService.message();
    }
}
