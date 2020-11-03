package com.relayr.service.impl;

import com.relayr.model.Product;
import com.relayr.repo.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProductServiceImplTest {

    Product product = new Product();
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        product.setName("abc");
        product.setCategory("abc");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        Iterable<Product> productList1 = productService.findAll();
        assertNotNull(productList1);
    }

    @Test
    void getProductByNameAndCategory() {
    }

    @Test
    void saveProduct() {
        when(productRepository.save(product)).thenReturn(product);
        Product product1 = this.productService.saveProduct(product);
        assertNotNull(product1);
        assertEquals("abc",product1.getName());
    }
}
