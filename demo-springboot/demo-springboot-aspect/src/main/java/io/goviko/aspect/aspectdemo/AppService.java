package io.goviko.aspect.aspectdemo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.*;

@Service
public class AppService {

    public String message() {
        return format("%d  %s  lorem ipsum", Thread.currentThread().getId(), Thread.currentThread().getName());
    }
}
