package io.goviko.spring.guicedemo;

import com.google.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private final AppService appService;

    @Inject
    public AppController(AppService theAppService) {
        appService = theAppService;
    }

    @GetMapping("/status")
    public String status(){
        return appService.message();
    }
}
