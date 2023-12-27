package dev.sameer.productservice.controller;

import dev.sameer.productservice.dto.GenericDto;
import dev.sameer.productservice.model.Product;
import dev.sameer.productservice.service.FakeStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/products/")
public class ProductController {

    @Autowired
    FakeStoreProductService fakeStoreProductService;


    @GetMapping("{id}")
    private Product getProductByID(@PathVariable("id") long ID){

         Product genericDto = fakeStoreProductService.getProductById(ID);
         return genericDto;
    }

    @GetMapping("all")
    private String getAllProducts(){
        return fakeStoreProductService.getAllProducts();
    }
}
