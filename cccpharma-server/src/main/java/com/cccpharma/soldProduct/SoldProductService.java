package com.cccpharma.soldProduct;

import java.util.List;

/**
 * Interface for service operations on a repository for the {@code SoldProduct} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see SoldProduct
 */
public interface SoldProductService {

    /**
     * Retrieves an sold product by its id.
     *
     * @param id must not be {@literal null}
     * @return the entity with the given id or {@literal null} if none found
     */
    SoldProduct findById(Long id);

    /**
     * Saves a given sold product.
     *
     * @param soldProduct must not be {@literal null}
     * @return the saved sold product, it will never be {@literal null}
     */
    SoldProduct save(SoldProduct soldProduct);

    /**
     * Deletes an sold product by its id.
     *
     * @param id must not be {@literal null}
     */
    void deleteById(Long id);

    /**
     * Returns all instances of sold products.
     *
     * @return all sold products
     */
    List<SoldProduct> findAll();
}
