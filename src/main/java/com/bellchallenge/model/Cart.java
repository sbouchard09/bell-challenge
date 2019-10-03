package com.bellchallenge.model;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a cart
 * A cart may contain 1 or more products (saved in the cartProducts list)
 */
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(cascade = CascadeType.ALL)
    @Valid
    private List<CartProduct> cartProducts;

    public Cart() { }

    public Cart(Long id) {
        cartProducts = new ArrayList<>();
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public CartProduct getCartProduct(Product product) {
        for(int i = 0; i < ((List<CartProduct>) cartProducts).size(); i++) {
            CartProduct cp = ((List<CartProduct>) cartProducts).get(i);
            if(cp.getProduct().equals(product)) {
                return cp;
            }
        }
        return null;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
