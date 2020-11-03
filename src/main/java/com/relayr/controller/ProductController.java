package com.relayr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.relayr.model.Product;
import com.relayr.service.impl.ProductServiceImpl;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/findAllProduct")
    public Iterable<Product> getProduct() {
        return this.productServiceImpl.findAll();
    }

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product) {
        return this.productServiceImpl.saveProduct(product);
    }

}
