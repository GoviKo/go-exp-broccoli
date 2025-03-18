package io.goviko.interceptor.interceptordemo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;

import io.goviko.interceptor.interceptordemo.controller.*;
import io.goviko.interceptor.interceptordemo.service.*;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@WebMvcTest(value = AppController.class)
public class InterceptorAppTests {

    @Autowired
    private MockMvc mockMvc;

     @MockBean
     private AppService appService;
 

    @Test
    void shouldReturnUnauthorizedWhenApiKeyHeaderMissing() throws Exception {
        this.mockMvc
            .perform(get("/message"))
            .andExpect(status().isUnauthorized())
            .andExpect(header().exists("x-timestamp"))
            .andExpect(header().exists("x-app"));
    }

    @Test
    void shouldReturnForbiddenWhenInvalidApiKey() throws Exception {
        this.mockMvc
            .perform(get("/message")
                     .header("X-API-KEY", "thisIsNotTheKeyToSuccess"))
            .andExpect(status().isForbidden())
            .andExpect(header().exists("x-timestamp"))
            .andExpect(header().exists("x-app"));
    }

    @Test
    void shouldAllowAccessWithValidApiKey() throws Exception {
        when(appService.message())
            .thenReturn("foo bar`");

        this.mockMvc
            .perform(get("/message")
                     .header("X-API-KEY", "zxcvuiopghjklbnmasdfytrewq"))
            .andExpect(status().isOk())
            .andExpect(content().string("foo bar"))
            .andExpect(header().exists("x-timestamp"))
            .andExpect(header().exists("x-app"));
    }
}
