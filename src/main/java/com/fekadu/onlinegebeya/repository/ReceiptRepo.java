package com.fekadu.onlinegebeya.repository;

import com.fekadu.onlinegebeya.domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepo extends JpaRepository<Receipt, Long> {
}
