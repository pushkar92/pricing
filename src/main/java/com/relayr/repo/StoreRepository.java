package com.relayr.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relayr.model.Store;

public interface StoreRepository extends CrudRepository<Store, Long> { 
	
	List<Store> findByName(String name);
	
	Optional<Store> findById(Long id);

}
