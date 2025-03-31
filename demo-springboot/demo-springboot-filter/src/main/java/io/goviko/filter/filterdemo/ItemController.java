package io.goviko.filter.filterdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/books")
    public String orderBook() {
        System.out.printf("%s%n", Thread.currentThread().getName());
        return itemService.orderBook();
    }
}
