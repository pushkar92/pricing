package com.relayr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relayr.model.Store;
import com.relayr.service.impl.StoreServiceImpl;

@RestController
public class StoreController {

    @Autowired
    private StoreServiceImpl storeService;

    @PostMapping("/saveStore")
    public Store saveStore(@RequestBody Store store) {
        return this.storeService.saveStore(store);
    }
}
