package com.relayr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relayr.model.Product_Store_Details;
import com.relayr.service.impl.ProductStoreDetailServiceImpl;

@RestController
public class ProductStoreDetailController {

    @Autowired
    private ProductStoreDetailServiceImpl productStoreDetailService;

    @PostMapping("/saveProductStoreDetail")
    public Product_Store_Details saveProductStoreDetail(@RequestBody Product_Store_Details product_store_details) {
        return this.productStoreDetailService.save(product_store_details);
    }
}
