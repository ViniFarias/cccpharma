package com.cccpharma.category;

import java.util.List;

/**
 * Interface for service operations on a repository for the {@code Category} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see Category
 */
public interface CategoryService {

    /**
     * Retrieves a category by its id.
     *
     * @param id must not be {@literal null}
     * @return the category with the given id or {@literal null} if none found
     */
    Category findById(Long id);

    /**
     * Saves a given category.
     *
     * @param category must not be {@literal null}
     * @return the saved category, it will never be {@literal null}
     */
    Category save(Category category);

    /**
     * Returns all instances of categories.
     *
     * @return all categories
     */
    List<Category> findAll();

    /**
     * Deletes a category by its id.
     *
     * @param id must not be {@literal null}
     */
    void deleteById(Long id);
}
