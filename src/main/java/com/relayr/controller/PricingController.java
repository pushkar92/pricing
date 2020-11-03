package com.relayr.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.relayr.model.PricingModel;
import com.relayr.service.impl.PricingServiceImpl;

@RestController("/pricing")
public class PricingController {

	@Autowired
	private PricingServiceImpl pricingServiceImpl;
	
	RestTemplate restTemplate = new RestTemplate(); 
	
	 @Value("${recommend.service.address}")
	    private String address;

	@GetMapping("/name")
	public ResponseEntity<Iterable<PricingModel>> findByProductName(String productName) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(pricingServiceImpl.findByProductName(productName.toLowerCase()));
	}

	@GetMapping("/main")
	public ResponseEntity<Iterable<PricingModel>> findByProductandCategory(String productName, String category) {
		try {
		return ResponseEntity.status(HttpStatus.OK)
				.body(pricingServiceImpl.findByProductAndCategory(productName.toLowerCase(), category.toLowerCase()));
		}catch(Exception e) {
			return (ResponseEntity<Iterable<PricingModel>>) ResponseEntity.status(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ranked")
	public ResponseEntity<List> findByProductandCategoryRanked(String productName, String category) throws URISyntaxException {
		HttpEntity<List> request = new HttpEntity(pricingServiceImpl.findByProductAndCategory(productName.toLowerCase(), category.toLowerCase()));
		ResponseEntity<List> response = restTemplate
				  .exchange(address, HttpMethod.POST, request, List.class);
		return response;
	}

}
