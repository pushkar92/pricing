package com.relayr.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relayr.model.Product_Store_Details;
import com.relayr.repo.ProductStoreDetailRepositroy;
import com.relayr.service.ProductStoreDetailService;

@Service
public class ProductStoreDetailServiceImpl implements ProductStoreDetailService {

    @Autowired
    private ProductStoreDetailRepositroy productStoreDetailRepositroy;

    public Product_Store_Details save(Product_Store_Details product_store_details) throws ServiceException{
        try {
            return this.productStoreDetailRepositroy.save(product_store_details);
        }catch (Exception e){
            throw new ServiceException("save");
        }
    }
}
