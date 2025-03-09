package io.goviko.profile.profiledemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"prod"})
public class ProdMessageService implements AppService {

    @Override
    public String message(){
        return "this is that PROD message";
    }
}
