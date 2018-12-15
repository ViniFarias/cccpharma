package com.cccpharma.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interface for CRUD operations on a repository for the {@code Product} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see Product
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

    /**
     * Retrieves the instances of products by its name.
     *
     * @param name must not be {@literal null}
     * @return the products with the given name or {@literal null} if none found
     */
    List<Product> findAllByName(String name);

    /**
     * Retrieves the instances of products by its manufacturer.
     *
     * @param manufacturer must not be {@literal null}
     * @return the products with the given manufacturer or {@literal null} if none found
     */
    List<Product> findAllByManufacturer(String manufacturer);

    /**
     * Retrieves the instances of products by its availability.
     *
     * @param available must not be {@literal null}
     * @return the products with the given availability or {@literal null} if none found
     */
    List<Product> findAllByAvailable(boolean available);

    List<Product> findAllByNameContains(String name);
}
