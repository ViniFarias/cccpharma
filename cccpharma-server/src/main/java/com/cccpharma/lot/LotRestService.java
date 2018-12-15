package com.cccpharma.lot;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Interface for CRUD operations on a repository for the {@code Lot} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see Lot
 */
@RestController
@AllArgsConstructor
@RequestMapping("/lots")
public class LotRestService {

    /**
     * The lots operations service.
     */
    @Autowired
    private LotService lotService;

    /**
     * Returns all instances of lots.
     * It can be accessed by a GET request to the {@code '/lots'} endpoint.
     *
     * @return all lots
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Lot> findAll() {
        return lotService.findAll();
    }

    /**
     * Retrieves an lot by its id.
     * It can be accessed by a GET request to the {@code '/lots/{id}'} endpoint
     * passing the lot id.
     *
     * @param id must not be {@literal null}
     * @return the lot with the given id or {@literal null} if none found
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lot findById(@PathVariable Long id) {
        return lotService.findById(id);
    }

    /**
     * Register a given lot.
     * It can be accessed by a POST request to the {@code '/lots'} endpoint,
     * passing a lot in the request body.
     *
     * @param lot must not be {@literal null}
     * @return the saved lot, it will never be {@literal null}
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lot save(@RequestBody Lot lot) {
        return lotService.save(lot);
    }

    /**
     * Deletes a lot by its id.
     * It can be accessed by a DELETE request to the {@code '/lots'} endpoint,
     * passing a lot in the endpoint.
     *
     * @param id must not be {@literal null}
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        lotService.deleteById(id);
    }

}
