package com.cccpharma.product;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * The {@code ProductRestService} class is the web controller for sales operations.
 * It can be accessed by {@code '/products'} endpoint.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 */
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductRestService {

    /**
     * The products operations service.
     */
    @Autowired
    private ProductService productService;

    /**
     * Returns all instances of products.
     * It can be accessed by a GET request to the {@code '/products'} endpoint.
     *
     * @return all products
     */
    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    /**
     * Retrieves an product by its id.
     * It can be accessed by a GET request to the {@code '/products/{id}'} endpoint
     * passing the product id.
     *
     * @param id must not be {@literal null}
     * @return the product with the given id or {@literal null} if none found
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable  String id) {
        return productService.findById(id);
    }


    /**
     * Register a given product.
     * It can be accessed by a POST request to the {@code '/product'} endpoint,
     * passing a product in the request body.
     *
     * @param product must not be {@literal null}
     * @return the saved product, it will never be {@literal null}
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    /**
     * Deletes an product by its id.
     * It can be accessed by a DELETE request to the {@code '/products/{id}'} endpoint
     * passing the product id.
     *
     * @param id must not be {@literal null}
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable String id) {
        productService.deleteById(id);
    }

    /**
     * Retrieves the price of a product by its id.
     * It can be accessed by a GET request to the {@code '/products/{id}/price'} endpoint
     * passing the product id.
     *
     * @param id must not be {@literal null}
     * @return the price of the product with the given id or {@literal null} if none found
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}/price", method = RequestMethod.GET)
    public Double getProductPriceById(@PathVariable String id) { return productService.getProductPriceById(id); }

    /**
     * Retrieves the instances of available products.
     * It can be accessed by a GET request to the {@code '/products/available'} endpoint.
     *
     * @return the available products or {@literal null} if none found
     */
    @GetMapping(value = "/available")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllByAvailable() {
        return productService.findAllByAvailable();
    }

    /**
     * Retrieves the instances of products by its name.
     * It can be accessed by a GET request to the {@code '/products/name/{name}'} endpoint
     * passing the product name.
     *
     * @param name must not be {@literal null}
     * @return the products with the given name or {@literal null} if none found
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/name/{name}")
    public List<Product> findByName(@PathVariable String name){
        return productService.findAllByName(name);
    }

    /**
     * Retrieves the instances of products by its manufacturer.
     * It can be accessed by a GET request to the {@code '/products/manufacturer/{manufacturer}'} endpoint
     * passing the product manufacturer.
     *
     * @param manufacturer must not be {@literal null}
     * @return the products with the given manufacturer or {@literal null} if none found
     */
    @GetMapping(value = "/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllByManufacturer(@PathVariable String manufacturer){
        return productService.findAllByManufacturer(manufacturer);
    }

    /**
     * Returns if a product exists by its id.
     * It can be accessed by a GET request to the {@code '/{id}/exists'} endpoint.
     *
     * @param id must not be {@literal null}
     * @return {@code true} if the product with given id exists ou {@code false} if not.
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}/exists")
    public boolean existsById(@PathVariable String id){
        return productService.existsById(id);
    }
}
