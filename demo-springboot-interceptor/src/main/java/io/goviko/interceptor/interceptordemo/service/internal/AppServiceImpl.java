package io.goviko.interceptor.interceptordemo.service.internal;

import org.springframework.stereotype.Service;
import io.goviko.interceptor.interceptordemo.service.*; 

@Service
public class AppServiceImpl implements AppService {

    @Override
    public String message() {
        return "lorem ipsum";
    }
}
