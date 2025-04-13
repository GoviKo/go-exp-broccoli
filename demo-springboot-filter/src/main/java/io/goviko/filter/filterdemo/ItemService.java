package io.goviko.filter.filterdemo;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private static int bookOrderId = 0;

    public String orderBook() {     
        bookOrderId += 1;
        return new String("Ordered Book with id = " + bookOrderId);
    }
}
