package com.relayr.service;

import org.hibernate.service.spi.ServiceException;

import com.relayr.model.Product_Store_Details;

public interface ProductStoreDetailService {

    public Product_Store_Details save(Product_Store_Details product_store_details) throws ServiceException;
}
