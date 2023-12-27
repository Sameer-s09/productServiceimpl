package dev.sameer.productservice.service;

import dev.sameer.productservice.model.Product;

public interface ProductService {

     Product getProductById(long ID);
     String getAllProducts();
}
