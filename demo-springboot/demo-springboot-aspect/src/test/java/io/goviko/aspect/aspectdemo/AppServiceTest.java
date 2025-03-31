package io.goviko.aspect.aspectdemo;

import io.goviko.aspect.aspectdemo.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class AppServiceTest {

    @InjectMocks
    private AppService appService;
    
    @Test
    void messageTest() {
        String actual = appService.message();
        assertThat(actual).contains("lorem ipsum");
    }
}
