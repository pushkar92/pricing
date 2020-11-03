package com.relayr.controller;

import com.relayr.model.Store;
import com.relayr.repo.ProductRepository;
import com.relayr.service.impl.StoreServiceImpl;
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
@WebMvcTest(StoreController.class)
public class StoreControllerTest {

    Store store = new Store();
    @Autowired
    private MockMvc mvc;
    @MockBean
    private StoreServiceImpl storeService;
    @MockBean
    private ProductRepository repository;

    public StoreControllerTest() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        store.setName("abc");
    }

    @Test
    public void saveProduct() throws Exception {
        given(this.storeService.saveStore(store)).willReturn(store);

        this.mvc.perform(MockMvcRequestBuilders.post("/saveStore")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"name\": \"abc\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }
}
