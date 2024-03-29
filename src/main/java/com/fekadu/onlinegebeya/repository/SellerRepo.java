package com.fekadu.onlinegebeya.repository;

import com.fekadu.onlinegebeya.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Long> {

    @Query(value="SELECT s FROM Seller s WHERE s.isApproved = ?1")
    public List<Seller> findByApproved(boolean b);

    @Query(value = "select s from Seller s where s.user.id = ?1")
    Seller findSellerByUserId(Long id);
}
