package com.bellchallenge.controller;

import com.bellchallenge.model.Cart;
import com.bellchallenge.model.CartProduct;
import com.bellchallenge.model.Product;
import com.bellchallenge.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart controller
 */
@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping(value = "/carts/{cartId}")
    public @ResponseBody ResponseEntity<List<ProductQuantity>> viewCart(@PathVariable("cartId") Long cartId) {
        Iterable<CartProduct> cartProducts = cartService.getProducts(cartId);
        List<ProductQuantity> products = new ArrayList<>();
        for(CartProduct cartProduct : cartProducts) {
            products.add(new ProductQuantity(cartProduct.getProduct(), cartProduct.getQuantity()));
        }
        return new ResponseEntity<List<ProductQuantity>>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/carts/{cartId}/remove")
    public @ResponseBody ResponseEntity<String> remove(@PathVariable("cartId") Long cartId, @RequestParam("productId") Long productId) {
        String message = cartService.remove(cartId, productId);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @PostMapping(value = "/carts/{cartId}/add")
    public @ResponseBody ResponseEntity<String> add(@PathVariable("cartId") Long cartId, @RequestParam("productId") Long productId) {
        String message = cartService.add(cartId, productId);
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }

    /**
     * Used to display the quantity of a given product when calling the viewCart method
     */
    class ProductQuantity {

        Product product;
        Integer quantity;

        ProductQuantity(Product product, Integer quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
