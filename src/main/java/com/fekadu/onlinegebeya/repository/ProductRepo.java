package com.fekadu.onlinegebeya.repository;

import com.fekadu.onlinegebeya.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query(value = "SELECT p FROM Product p WHERE p.isAnAdd=?1")
    public List<Product> findByAnAdd(boolean b);
}
