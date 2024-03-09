package dev.sameer.productservice.service;

import dev.sameer.productservice.exceptions.NotFoundException;
import dev.sameer.productservice.model.Product;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class FakeStoreProductServiceTest {

    @MockBean
    FakeStoreProductService fakeStoreProductService;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Test
    void returnNullWhenProductNotFound() throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
       Product product = fakeStoreProductService.getProductById(12L);

        when(fakeStoreProductService.getProductById(12L)).thenReturn(null);

        assertNull(product);
    }

    @Test
    void throwsNotFoundExceptionWhenProductNotFound() throws NotFoundException {
        when(fakeStoreProductService.getProductById(any(Long.class))).thenReturn(null);
        Product product = fakeStoreProductService.getProductById(12L);

        assertThrows(NotFoundException.class,() -> fakeStoreProductService.getProductById(12L));
    }

//    @Test
//    void returnHttpStatus200() throws NotFoundException {
//        Product product = fakeStoreProductService.getProductById(12L);
//        when(fakeStoreProductService.getProductById(12L)).thenReturn(n);
//        assertEquals(200,);
//    }
}