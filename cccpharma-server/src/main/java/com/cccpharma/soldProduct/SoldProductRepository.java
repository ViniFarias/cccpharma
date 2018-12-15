package com.cccpharma.soldProduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for CRUD operations on a repository for the {@code SoldProduct} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see SoldProduct
 */
@Repository
public interface SoldProductRepository extends CrudRepository<SoldProduct, Long> {}
