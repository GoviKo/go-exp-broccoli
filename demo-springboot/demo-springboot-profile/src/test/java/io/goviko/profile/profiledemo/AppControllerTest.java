package io.goviko.profile.profiledemo;

import io.goviko.profile.profiledemo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = AppController.class)
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

     @MockBean
     private AppService appService;

    @Test
    void shouldReturnOkWhenStatus() throws Exception {
        when(appService.message())
            .thenReturn("status check");

        this.mockMvc
            .perform(get("/status"))
            .andExpect(status().isOk())
            .andExpect(content().string("status check"));
    }
}
