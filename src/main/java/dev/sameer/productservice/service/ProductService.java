package dev.sameer.productservice.service;

import dev.sameer.productservice.model.Product;

import java.util.List;

public interface ProductService {

     Product getProductById(long ID);
     List<Product> getAllProducts();
}
