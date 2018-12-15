package com.cccpharma.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for CRUD operations on a repository for the {@code Category} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see Category
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {}
