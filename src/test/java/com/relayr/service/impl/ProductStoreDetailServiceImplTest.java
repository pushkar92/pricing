package com.relayr.service.impl;

import com.relayr.model.Product_Store_Details;
import com.relayr.repo.ProductStoreDetailRepositroy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProductStoreDetailServiceImplTest {

    Product_Store_Details product_store_details = new Product_Store_Details();
    @InjectMocks
    private ProductStoreDetailServiceImpl productStoreDetailService;
    @Mock
    private ProductStoreDetailRepositroy productStoreDetailRepositroy;

    @BeforeEach
    void setUp() {
        product_store_details.setStoreId(1L);
        product_store_details.setProductId(1L);
        product_store_details.setSp(15);
        product_store_details.setMrp(12);
        product_store_details.setLink("www.google.com");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        when(productStoreDetailRepositroy.save(product_store_details)).thenReturn(product_store_details);
        Product_Store_Details product_store_details1 = this.productStoreDetailService.save(product_store_details);
        assertNotNull(product_store_details1);
    }
}
