package com.fekadu.onlinegebeya.repository;

import com.fekadu.onlinegebeya.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

//    Optional<Cart> findByBuyer(Buyer buyer);
}
