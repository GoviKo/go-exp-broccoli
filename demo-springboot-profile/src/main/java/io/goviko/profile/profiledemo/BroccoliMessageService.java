package io.goviko.profile.profiledemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"broccoli"})
public class BroccoliMessageService implements AppService {

    @Override
    public String message(){
        return "broccoli message";
    }
}
