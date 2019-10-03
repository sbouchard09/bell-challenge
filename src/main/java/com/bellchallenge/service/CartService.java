package com.bellchallenge.service;

import com.bellchallenge.model.Cart;
import com.bellchallenge.model.CartProduct;
import com.bellchallenge.model.Product;

import java.util.List;

public interface CartService {

    String add(Long cartId, Long productId);
    String remove(Long cartId, Long productId);
    Cart addCart(Cart c);
    Iterable<CartProduct> getProducts(Long cartId);
}
