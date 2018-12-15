package com.cccpharma.product;

import java.util.List;

/**
 * Interface for service operations on a repository for the {@code Product} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see Product
 */
public interface ProductService {

    /**
     * Retrieves a product by its id.
     *
     * @param id must not be {@literal null}
     * @return the product with the given id or {@literal null} if none found
     */
    Product findById(String id);

    /**
     * Saves a given product.
     *
     * @param product must not be {@literal null}
     * @return the saved product, it will never be {@literal null}
     */
    Product save(Product product);

    /**
     * Deletes a product by its id.
     *
     * @param id must not be {@literal null}
     */
    void deleteById(String id);

    /**
     * Returns all instances of products.
     *
     * @return all products
     */
    List<Product> findAll();

    /**
     * Retrieves the instances of products by its name.
     *
     * @param name must not be {@literal null}
     * @return the products with the given name or {@literal null} if none found
     */
    List<Product> findAllByName(String name);

    /**
     * Retrieves the instances of available products.
     *
     * @return the available products or {@literal null} if none found
     */
    List<Product> findAllByAvailable();

    /**
     * Retrieves the instances of products by its manufacturer.
     *
     * @param manufacturer must not be {@literal null}
     * @return the products with the given manufacturer or {@literal null} if none found
     */
    List<Product> findAllByManufacturer(String manufacturer);

    /**
     * Retrieves the price of a product by its id.
     *
     * @param id must not be {@literal null}
     * @return the price of the product with the given id or {@literal null} if none found
     */
    double getProductPriceById(String id);

    /**
     * Returns if a product exists by its id.
     *
     * @param id must not be {@literal null}
     * @return {@code true} if the product with given id exists ou {@code false} if not.
     */
    boolean existsById(String id);

    /**
     * Retrieves the instances of products that contains the given text in the name.
     *
     * @param text must not be {@literal null}
     * @return the products with the given name or {@literal null} if none found
     */
    List<Product> findAllByNameContains(String text);
}
