package dev.sameer.productservice.controller;

import dev.sameer.productservice.dto.ExceptionDto;
import dev.sameer.productservice.dto.GenericDto;
import dev.sameer.productservice.exceptions.NotFoundException;
import dev.sameer.productservice.model.Product;
import dev.sameer.productservice.service.FakeStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/products/")
public class ProductController {

    @Autowired
    FakeStoreProductService fakeStoreProductService;

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity(
                new ExceptionDto(HttpStatus.NOT_FOUND,notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
    @GetMapping("{id}")
    private Product getProductByID(@PathVariable("id") long ID) throws NotFoundException {

         Product genericDto = fakeStoreProductService.getProductById(ID);
         return genericDto;
    }

    @GetMapping("all")
    private List<Product> getAllProducts(){
        return fakeStoreProductService.getAllProducts();
    }
}
