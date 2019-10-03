package com.bellchallenge.service;

import com.bellchallenge.errorhandling.CartNotFoundException;
import com.bellchallenge.errorhandling.ProductNotFoundException;
import com.bellchallenge.model.Cart;
import com.bellchallenge.model.CartProduct;
import com.bellchallenge.model.Product;
import com.bellchallenge.repository.CartRepository;
import com.bellchallenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Cart Service implementation
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CartRepository cartRepo;

    /**
     * Add a product to the cart.
     * If the product already exists in the cart, increment the quantity
     *
     * @param cartId
     * @param productId
     * @return
     */
    public String add(Long cartId, Long productId) {
        Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart not found"));
        Product product = productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        CartProduct cartProduct = cart.getCartProduct(product);
        if(cartProduct == null) {
            cart.getCartProducts().add(new CartProduct(cart, product));
            cartRepo.save(cart);
        } else {
            int quantity = cartProduct.getQuantity();
            cartProduct.setQuantity(quantity + 1);
            cartRepo.save(cart);
        }

        return "Product '" + product.getName() + "' added to cart";
    }

    /**
     * Remove a product from the cart.
     * If the product's quantity is >1, decrement the quantity, otherwise remove it from the cart
     *
     * @param cartId
     * @param productId
     * @return
     */
    public String remove(Long cartId, Long productId) {
        Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart with ID '" + cartId + "' not found."));
        Product product = productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product with ID '" + productId + "' not found."));
        Iterable<CartProduct> cartProducts = cart.getCartProducts();
        CartProduct cartProduct = cart.getCartProduct(product);
        if(cartProduct == null) {
            return "Product does not exist in the cart";
        } else {
            int quantity = cartProduct.getQuantity();
            if(quantity - 1 == 0) {
                ((List<CartProduct>) cartProducts).remove(cartProduct);
            } else {
                cartProduct.setQuantity(quantity - 1);
            }
            cartRepo.save(cart);
            return "Product '" + cartProduct.getProduct().getName() + "' removed from cart";
        }
    }

    /**
     * Add a new cart
     *
     * @param c
     * @return
     */
    public Cart addCart(Cart c) {
        return cartRepo.save(c);
    }

    /**
     * Returns a list of products in the cart
     *
     * @param cartId
     * @return
     */
    public Iterable<CartProduct> getProducts(Long cartId) {
        Cart cart = cartRepo.findByCartId(cartId);
        return cart.getCartProducts();
    }
}
