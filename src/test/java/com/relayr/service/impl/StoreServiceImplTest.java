package com.relayr.service.impl;

import com.relayr.model.Store;
import com.relayr.repo.StoreRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class StoreServiceImplTest {

    Store store = new Store();
    @InjectMocks
    private StoreServiceImpl storeService;
    @Mock
    private StoreRepository storeRepository;

    @BeforeEach
    void setUp() {
        store.setName("abc");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveStore() {
        when(storeRepository.save(store)).thenReturn(store);
        Store store1 = this.storeService.saveStore(store);
        assertNotNull(store1);
        assertEquals("abc", store1.getName());
    }
}
