package com.bellchallenge.repository;

import com.bellchallenge.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    public Cart findByCartId(Long id);
}
