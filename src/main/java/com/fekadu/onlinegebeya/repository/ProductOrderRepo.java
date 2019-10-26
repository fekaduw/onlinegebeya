package com.fekadu.onlinegebeya.repository;


import com.fekadu.onlinegebeya.domain.Buyer;
import com.fekadu.onlinegebeya.domain.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepo extends JpaRepository<ProductOrder,Long> {
    List<ProductOrder> getAllByBuyer(Buyer buyer);
}
