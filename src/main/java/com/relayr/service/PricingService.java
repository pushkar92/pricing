package com.relayr.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.relayr.model.PricingModel;
import com.relayr.model.PricingModel;

public interface PricingService {
	
	Iterable<PricingModel> findAll(String PricingModelName) throws ServiceException;

	void savePricingModel(List<PricingModel> pricingModels) throws ServiceException;

	Iterable<PricingModel> findByProductName(String productName) throws ServiceException;

	Iterable<PricingModel> findByProductAndCategory(String productName, String category) throws ServiceException;

}
