package com.cccpharma.sale;

import java.util.List;

/**
 * Interface for service operations on a repository for the {@code Sale} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see Sale
 */
public interface SaleService {

    /**
     * Retrieves aa sale by its id.
     *
     * @param id must not be {@literal null}
     * @return the entity with the given id or {@literal null} if none found
     */
    Sale findById(Long id);

    /**
     * Saves a given sale.
     *
     * @param sale must not be {@literal null}
     * @return the saved sale, it will never be {@literal null}
     */
    Sale save(Sale sale);

    /**
     * Returns all instances of sales.
     *
     * @return all sales
     */
    List<Sale> findAll();

    /**
     * Deletes a sale by its id.
     *
     * @param id must not be {@literal null}
     */
    void deleteById(Long id);
}
