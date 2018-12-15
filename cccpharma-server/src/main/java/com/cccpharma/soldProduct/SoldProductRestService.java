package com.cccpharma.soldProduct;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * The {@code SoldProductRestService} class is the web controller for sold products operations.
 * It can be accessed by {@code '/soldproducts'} endpoint.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 */
@RestController
@AllArgsConstructor
@RequestMapping("/soldproducts")
public class SoldProductRestService {

    /**
     * The sold products operations service.
     */
    @Autowired
    private SoldProductService soldProductService;

    /**
     * Returns all instances of sold products.
     * It can be accessed by a GET request to the {@code '/soldproducts'} endpoint.
     *
     * @return all sold products
     */
    @GetMapping
    public List<SoldProduct> findAll() {
        return soldProductService.findAll();
    }

    /**
     * Register a given sold product.
     * It can be accessed by a POST request to the {@code '/soldproducts'} endpoint,
     * passing a sold product in the request body.
     *
     * @param soldProduct must not be {@literal null}
     * @return the saved sold product, it will never be {@literal null}
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SoldProduct save(@RequestBody SoldProduct soldProduct) {
        return soldProductService.save(soldProduct);
    }
}
