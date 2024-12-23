package com.example.paginationDemo.service;

import com.example.paginationDemo.entity.Item;
import com.example.paginationDemo.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    public Page<Item> getPaginatedItems(Pageable pageable) {
        return itemRepo.findAll(pageable);
    }
}

