package com.cccpharma.service;

import com.cccpharma.domain.orm.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);
    Category save(Category category);
    List<Category> findAll();
    void deleteById(Long id);
}
