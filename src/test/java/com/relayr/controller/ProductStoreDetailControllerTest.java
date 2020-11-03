package com.relayr.controller;

import com.relayr.model.Product_Store_Details;
import com.relayr.repo.ProductRepository;
import com.relayr.service.impl.ProductStoreDetailServiceImpl;
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

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductStoreDetailController.class)
public class ProductStoreDetailControllerTest {

    Product_Store_Details product_store_details = new Product_Store_Details();
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ProductStoreDetailServiceImpl productStoreDetailService;
    @MockBean
    private ProductRepository repository;

    @BeforeEach
    void setUp() {
        product_store_details.setLink("www.google.com");
        product_store_details.setMrp(12);
        product_store_details.setSp(15);
        product_store_details.setProductId(1L);
        product_store_details.setStoreId(1L);
    }

    @AfterEach
    void tearDown() {
    }

    public ProductStoreDetailControllerTest() {
    }

    @Test
    public void saveProduct() throws Exception {
        given(this.productStoreDetailService.save(product_store_details)).willReturn(product_store_details);

        this.mvc.perform(MockMvcRequestBuilders.post("/saveProductStoreDetail")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"link\": \"www.google.com\",\n" +
                        "  \"mrp\": 12,\n" +
                        "  \"productId\": 1,\n" +
                        "  \"sp\": 15,\n" +
                        "  \"storeId\": 1\n" +
                        "}"))
                .andExpect(status().isOk());
    }
}
