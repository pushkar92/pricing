package com.relayr.service;

import org.hibernate.service.spi.ServiceException;

import com.relayr.model.Product;

public interface ProductService {

    public Iterable<Product> findAll() throws ServiceException;

    public Product saveProduct(Product product) throws ServiceException;
}
