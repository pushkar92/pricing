package com.relayr.controller;

import com.relayr.model.Product;
import com.relayr.repo.ProductRepository;
import com.relayr.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    Product product = new Product();
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ProductServiceImpl productService;
    @MockBean
    private ProductRepository repository;

    public ProductControllerTest() {
    }

    @BeforeEach
    void setUp() {
        product.setName("Java");
        product.setCategory("iPhone");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void findAllProduct() throws Exception {
        Product product1 = new Product();
        product1.setName("node");
        product1.setCategory("iPhone");

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);

        given(this.productService.findAll()).willReturn(productList);

        this.mvc.perform(MockMvcRequestBuilders.get("/findAllProduct")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveProduct() throws Exception {
        given(this.productService.saveProduct(product)).willReturn(product);

        this.mvc.perform(MockMvcRequestBuilders.post("/saveProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"category\": \"abc\",\n" +
                        "  \"id\": 0,\n" +
                        "  \"name\": \"abc\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }
}
