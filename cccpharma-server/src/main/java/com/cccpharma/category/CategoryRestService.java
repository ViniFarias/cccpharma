package com.cccpharma.category;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Interface for CRUD operations on a repository for the {@code Category} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see Category
 */
@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryRestService {

    /**
     * The categories operations service.
     */
    @Autowired
    private CategoryService categoryService;

    /**
     * Returns all instances of categories.
     * It can be accessed by a GET request to the {@code '/categories'} endpoint.
     *
     * @return all categories
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    /**
     * Retrieves an category by its id.
     * It can be accessed by a GET request to the {@code '/categories/{id}'} endpoint
     * passing the category id.
     *
     * @param id must not be {@literal null}
     * @return the category with the given id or {@literal null} if none found
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    /**
     * Register a given category.
     * It can be accessed by a POST request to the {@code '/categories'} endpoint,
     * passing a category in the request body.
     *
     * @param category must not be {@literal null}
     * @return the saved category, it will never be {@literal null}
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    /**
     * Deletes a category by its id.
     * It can be accessed by a DELETE request to the {@code '/categories'} endpoint,
     * passing a category in the endpoint.
     *
     * @param id must not be {@literal null}
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
