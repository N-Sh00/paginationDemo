package com.example.paginationDemo.controller;

import com.example.paginationDemo.entity.Item;
import com.example.paginationDemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    private static final int ITEMS_PER_PAGE = 10;

    @GetMapping("/items")
    public Page<Item> getPaginatedItems(
            @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, ITEMS_PER_PAGE);
        return itemService.getPaginatedItems(pageable);
    }
}
