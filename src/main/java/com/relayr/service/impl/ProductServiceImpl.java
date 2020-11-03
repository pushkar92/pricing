package com.relayr.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relayr.model.Product;
import com.relayr.repo.ProductRepository;
import com.relayr.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll() throws ServiceException{
        try {
            return this.productRepository.findAll();
        }catch (Exception e){
            throw new ServiceException("findAll");
        }
    }

    public Product saveProduct(Product product) throws ServiceException {
        try {
            return this.productRepository.save(product);
        }catch (Exception e){
            throw new ServiceException("saveProduct");
        }
    }
}
