package io.goviko.filter.filterdemo;

import io.goviko.filter.filterdemo.ItemController;
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

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ItemController.class)
@ActiveProfiles("test")
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

     @MockBean
     private ItemService itemService;

    @Test
    void shouldReturnOkWhenBookOrder() throws Exception {
        when(itemService.orderBook())
            .thenReturn("ordered book");

        this.mockMvc
            .perform(post("/books"))
            .andExpect(status().isOk())
            .andExpect(header().exists("X-BOOK-APP"))
            .andExpect(header().exists("x-timestamp"))
            .andExpect(content().string("ordered book"));
    }

    @Test
    void shouldReturnNotAllowedWhenGetBookOrder() throws Exception {
        this.mockMvc
            .perform(get("/books"))
            .andExpect(status().isMethodNotAllowed())
            .andExpect(header().exists("X-BOOK-APP"))
            .andExpect(header().exists("x-timestamp"));
    }
}
