package com.cccpharma.category;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

/**
 * The {@code CategoryServiceImpl} class implements the {@code CategoryService} methods with the business rule.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see CategoryService
 */
@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    /**
     * The interface for operations on the category repository.
     */
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Returns all instances of categories.
     *
     * @return all categories
     */
    public List<Category> findAll() {

        Iterable<Category> categories = categoryRepository.findAll();
        List<Category> categoriesResult = new ArrayList<>();

        for(Category category : categories) {
            categoriesResult.add(category);
        }

        return categoriesResult;
    }

    /**
     * Retrieves a category by its id.
     *
     * @param id must not be {@literal null}
     * @return the category with the given id or {@literal null} if none found
     * @throws NullPointerException in case the given id is null
     * @throws RuntimeException in case the category is not found
     */
    public Category findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Category id is null!");
        }
        if(!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found!");
        }

        return categoryRepository.findById(id).get();
    }

    /**
     * Saves a given category.
     *
     * @param category must not be {@literal null}
     * @return the saved lot, it will never be {@literal null}
     * @throws NullPointerException in case the given category or its attributes are null
     * @throws RuntimeException in case the category is not found
     */
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

    /**
     * Deletes a category by its id.
     *
     * @param id must not be {@literal null}
     * @throws NullPointerException in case the given id is null
     * @throws RuntimeException in case the category is not found
     */
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
