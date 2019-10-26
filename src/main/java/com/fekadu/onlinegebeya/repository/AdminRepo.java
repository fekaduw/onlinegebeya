package com.fekadu.onlinegebeya.repository;

import com.fekadu.onlinegebeya.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
}
