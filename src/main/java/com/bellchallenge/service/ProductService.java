package com.bellchallenge.service;

import com.bellchallenge.model.Product;

public interface ProductService {
    Product getProduct(Long id);
    Iterable<Product> getAllProducts();
    Product addProduct(Product p);
}
