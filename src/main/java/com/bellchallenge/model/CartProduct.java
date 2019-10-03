package com.bellchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * CartProduct model
 * Necessary to link a product with an order
 */
@Entity
public class CartProduct {

    @EmbeddedId
    @JsonIgnore
    private CartProductKey key;

    @Column(name = "quantity")
    private Integer quantity;

    public CartProduct() {
        this.quantity = 1;
    }

    public CartProduct(Cart cart, Product product) {
        key = new CartProductKey(cart, product);
        this.quantity = 1;
    }

    @Transient
    public Product getProduct() {
        return key.getProduct();
    }

    @Transient
    public Cart getCart() {
        return key.getCart();
    }

    public CartProductKey getKey() {
        return key;
    }

    public void setKey(CartProductKey key) {
        this.key = key;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
