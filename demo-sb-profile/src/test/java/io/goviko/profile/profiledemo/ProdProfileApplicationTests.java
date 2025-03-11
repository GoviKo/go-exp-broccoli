package io.goviko.profile.profiledemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("prod")
public class ProdProfileApplicationTests {

    @Autowired
    AppService appService;

    @Test
    void contextLoads() {
        String expected = "this is that PROD message";
        assertEquals(expected, appService.message());
    }
}
