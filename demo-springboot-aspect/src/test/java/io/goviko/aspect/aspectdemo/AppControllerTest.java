package io.goviko.aspect.aspectdemo;

import io.goviko.aspect.aspectdemo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = AppController.class)
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

     @MockBean
     private AppService appService;

    @Test
    void shouldReturnOkWhenLorem() throws Exception {
        when(appService.message())
            .thenReturn("foo bar");

        this.mockMvc
            .perform(get("/lorem"))
            .andExpect(status().isOk())
            .andExpect(content().string("foo bar"));
    }
}
