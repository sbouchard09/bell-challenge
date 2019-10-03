package com.bellchallenge.service;

import com.bellchallenge.errorhandling.ProductNotFoundException;
import com.bellchallenge.model.Product;
import com.bellchallenge.repository.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * Product service implementation
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    public Product addProduct(Product p) {
        return repo.save(p);
    }

    public Product getProduct(Long id) {
        return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public Iterable<Product> getAllProducts() {
        return repo.findAll();
    }
}
