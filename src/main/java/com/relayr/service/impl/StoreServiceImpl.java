package com.relayr.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relayr.model.Store;
import com.relayr.repo.StoreRepository;
import com.relayr.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store saveStore(Store store) throws ServiceException {
        try {
             return this.storeRepository.save(store);
        }catch (Exception e){
            throw new ServiceException("save");
        }
    }
}
