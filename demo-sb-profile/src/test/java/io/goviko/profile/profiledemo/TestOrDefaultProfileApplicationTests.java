package io.goviko.profile.profiledemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles({"test", "default"})
public class TestOrDefaultProfileApplicationTests {

    @Autowired
    AppService appService;

    @Test
    void contextLoads() {
        String expected = "lorem ipsum";
        assertEquals(expected, appService.message());
    }
}
