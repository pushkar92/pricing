package com.relayr.service;

import org.hibernate.service.spi.ServiceException;

import com.relayr.model.Store;

public interface StoreService {

    public Store saveStore(Store store) throws ServiceException;
}
