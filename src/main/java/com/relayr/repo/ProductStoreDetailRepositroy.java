package com.relayr.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.relayr.model.Product_Store_Details;

public interface ProductStoreDetailRepositroy extends CrudRepository<Product_Store_Details, Long> {
	
	List<Product_Store_Details> findByProductId(Long id);
}
