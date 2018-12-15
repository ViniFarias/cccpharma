package com.cccpharma.product;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

/**
 * The {@code ProductServiceImpl} class implements the {@code ProductService} methods with the business rule.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see ProductService
 */
@Service
@NoArgsConstructor
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    /**
     * The interface for operations on the product repository.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Returns all instances of products.
     *
     * @return all products
     */
    public List<Product> findAll() {

        Iterable<Product> products = productRepository.findAll();
        List<Product> productsResult = new ArrayList<>();

        for(Product product : products) {
            productsResult.add(product);
        }

        return productsResult;
    }


    /**
     * Retrieves the instances of products by its name.
     *
     * @param name must not be {@literal null}
     * @return the products with the given name or {@literal null} if none found
     * @throws NullPointerException in case the given name is null
     */
    public List<Product> findAllByName(String name){

        if(isNull(name)){
            throw new RuntimeException("Name is null!");
        }

        return productRepository.findAllByName(name);
    }

    /**
     * Retrieves the instances of available products.
     *
     * @return the available products or {@literal null} if none found
     */
    public List<Product> findAllByAvailable(){

        Iterable<Product> products = productRepository.findAllByAvailable(true);
        List<Product> productsResult = new ArrayList<>();

        for(Product product : products){
            productsResult.add(product);
        }

        return productsResult;
    }

    /**
     * Retrieves the instances of products by its manufacturer.
     *
     * @param manufacturer must not be {@literal null}
     * @return the products with the given manufacturer or {@literal null} if none found
     * @throws NullPointerException in case the given manufacturer is null
     */
    public List<Product> findAllByManufacturer(String manufacturer){

        if(isNull(manufacturer)){
            throw new RuntimeException("Manufacturer is null!");
        }

        return productRepository.findAllByManufacturer(manufacturer);
    }

    /**
     * Retrieves a product by its id.
     *
     * @param id must not be {@literal null}
     * @return the product with the given id or {@literal null} if none found
     * @throws NullPointerException in case the given id is null
     * @throws RuntimeException in case the product is not found
     */
    public Product findById(String id) {

        if(isNull(id)) {
            throw new NullPointerException("Product id is null!");
        }
        if(!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found!");
        }
        return productRepository.findById(id).get();
    }

    /**
     * Saves a given product.
     *
     * @param product must not be {@literal null}
     * @return the saved product, it will never be {@literal null}
     */
    public Product save(Product product) {
        return productRepository.save(product);
    }

    /**
     * Deletes a product by its id.
     *
     * @param id must not be {@literal null}
     */
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    /**
     * Returns if a product exists by its id.
     *
     * @param id must not be {@literal null}
     * @return {@code true} if the product with given id exists ou {@code false} if not
     */
    public boolean existsById(String id) {
        return productRepository.existsById(id);
    }

    /**
     * Retrieves the price of a product by its id.
     *
     * @param id must not be {@literal null}
     * @return the price of the product with the given id or {@literal null} if none found
     * @throws NullPointerException in case the given id is null
     * @throws RuntimeException in case the product is not found
     */
    public double getProductPriceById(String id) {
        if (isNull(id)) {
            throw new NullPointerException("Product id is null!");
        }
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found!");
        }

        return productRepository.findById(id).get().getPrice();
    }

    /**
     * Retrieves the instances of products that contains the given text in the name.
     *
     * @param text must not be {@literal null}
     * @return the products that contains the given text in the name or {@literal null} if none found
     * @throws NullPointerException in case the given text is null
     */
    public List<Product> findAllByNameContains(String text) {
        if (isNull(text)) {
            throw new NullPointerException("Text is null!");
        }

        return productRepository.findAllByNameContains(text);
    }

}
