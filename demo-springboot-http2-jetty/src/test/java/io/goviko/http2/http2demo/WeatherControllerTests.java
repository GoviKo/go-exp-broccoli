package io.goviko.http2.http2demo;

import io.goviko.http2.http2demo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = WeatherController.class)
public class WeatherControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void mockMvcNotNull() throws Exception {
        assertThat(this.mockMvc).isNotNull();
    }

    @Test
    void shouldReturnBadRequestWhenWeatherNoParam() throws Exception {
        this.mockMvc
            .perform(get("/weather"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequesthenWeatherWithEmptyParam() throws Exception {
        this.mockMvc
            .perform(get("/weather?city="))
            .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnOkWhenWeatherWithParam() throws Exception {
        this.mockMvc
            .perform(get("/weather?city=MN"))
            .andExpect(status().isOk());
    }
}
