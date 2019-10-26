package com.fekadu.onlinegebeya.service;

import com.fekadu.onlinegebeya.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category save(Category category);

    void delete(Long id);
}
