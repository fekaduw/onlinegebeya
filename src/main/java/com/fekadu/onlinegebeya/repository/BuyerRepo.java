package com.fekadu.onlinegebeya.repository;

import com.fekadu.onlinegebeya.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Long> {
    @Query(value="SELECT b FROM Buyer b WHERE b.user.id = ?1")
    public Buyer findByUserId(Long id);
}
