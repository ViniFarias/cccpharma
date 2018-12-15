package com.cccpharma.sale;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * The {@code SaleRestService} class is the web controller for sales operations.
 * It can be accessed by {@code '/sales'} endpoint.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SaleRestService {

    /**
     * The sales operations service.
     */
    @Autowired
    private SaleService saleService;

    /**
     * Returns all instances of sales.
     * It can be accessed by a GET request to the {@code '/sales'} endpoint.
     *
     * @return all sales
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Sale> findAll() {
        return saleService.findAll();
    }

    /**
     * Retrieves an sale by its id.
     * It can be accessed by a GET request to the {@code '/sales/{id}'} endpoint
     * passing the sale id.
     *
     * @param id must not be {@literal null}
     * @return the entity with the given id or {@literal null} if none found
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Sale findById(@PathVariable Long id) {
        return saleService.findById(id);
    }

    /**
     * Register a given sale.
     * It can be accessed by a POST request to the {@code '/sales'} endpoint,
     * passing a sale in the request body.
     *
     * @param sale must not be {@literal null}
     * @return the saved sale, it will never be {@literal null}
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sale save(@RequestBody Sale sale) {
        return saleService.save(sale);
    }

    /**
     * Deletes an sale by its id.
     * It can be accessed by a DELETE request to the {@code '/sales/{id}'} endpoint
     * passing the sale id.
     *
     * @param id must not be {@literal null}
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        saleService.deleteById(id);
    }

}
