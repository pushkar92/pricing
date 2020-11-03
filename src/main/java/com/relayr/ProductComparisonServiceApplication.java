package com.relayr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.relayr.model.Product;
import com.relayr.repo.ProductRepository;

@SpringBootApplication
@EntityScan(basePackages = { "com.relayr.model" })
public class ProductComparisonServiceApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProductComparisonServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {

		repository.save(new Product("Book","Java"));
		repository.save(new Product("Book","Node"));

		System.out.println("\nfindAll()");
		repository.findAll().forEach(x -> System.out.println(x.toString()));

		System.out.println("\nfindById(1L)");
		repository.findById(1l).ifPresent(x -> System.out.println(x.toString()));

		System.out.println("\nfindByName('Node')");
		repository.findByName("Node").forEach(x -> System.out.println(x.toString()));

	}

}
