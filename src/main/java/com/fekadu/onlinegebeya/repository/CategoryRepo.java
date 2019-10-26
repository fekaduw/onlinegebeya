package com.fekadu.onlinegebeya.repository;

import com.fekadu.onlinegebeya.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
