package com.cccpharma.category;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {

        Iterable<Category> categories = categoryRepository.findAll();
        List<Category> categoriesResult = new ArrayList<>();

        for(Category category : categories) {
            categoriesResult.add(category);
        }

        return categoriesResult;
    }

    public Category findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Category id is null!");
        }
        if(!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found!");
        }

        return categoryRepository.findById(id).get();
    }


    public Category save(Category category) {

        if(isNull(category)) {
            throw new NullPointerException("Category is null!");
        }
        if(isNull(category.getDiscount())) {
            throw new NullPointerException("Category discount is null!");
        }
        if(isNull(category.getName())) {
            throw new NullPointerException("Category name is null!");
        }

        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Category id is null!");
        }
        if(!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found!");
        }

        categoryRepository.deleteById(id);
    }
}
