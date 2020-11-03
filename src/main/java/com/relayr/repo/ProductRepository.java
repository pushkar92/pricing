package com.relayr.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relayr.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> { 
	
	//@Query("SELECT * FROM Product WHERE name like '%?1%'")
	List<Product> findByName(String name);

	List<Product> findByNameAndCategory(String name, String category);

}
