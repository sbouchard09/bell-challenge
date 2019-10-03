package com.bellchallenge.controller;

import com.bellchallenge.errorhandling.ProductNotFoundException;
import com.bellchallenge.model.Product;
import com.bellchallenge.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Product controller
 */
@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/products/{id}")
    public @ResponseBody ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product p = service.getProduct(id);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }

    @GetMapping(value = "/products")
    public @ResponseBody ResponseEntity<Iterable<Product>> getProducts() throws ProductNotFoundException {
        Iterable<Product> productList = service.getAllProducts();
        return new ResponseEntity<Iterable<Product>>(productList, HttpStatus.OK);
    }
}
