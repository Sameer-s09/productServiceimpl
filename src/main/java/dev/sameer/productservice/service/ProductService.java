package dev.sameer.productservice.service;

import dev.sameer.productservice.exceptions.NotFoundException;
import dev.sameer.productservice.model.Product;

import java.util.List;

public interface ProductService {

     Product getProductById(long ID) throws NotFoundException;
     List<Product> getAllProducts();
}
