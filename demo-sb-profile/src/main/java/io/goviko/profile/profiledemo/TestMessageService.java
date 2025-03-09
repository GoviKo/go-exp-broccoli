package io.goviko.profile.profiledemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"test", "default"})
public class TestMessageService implements AppService {

    @Override
    public String message(){
        return "lorem ipsum";
    }
}


