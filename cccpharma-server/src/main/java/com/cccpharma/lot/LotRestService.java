package com.cccpharma.lot;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/lots")
public class LotRestService {

    @Autowired
    private LotService lotService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Lot> findAll() {
        return lotService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lot findById(@PathVariable Long id) {
        return lotService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lot save(@RequestBody Lot lot) {
        return lotService.save(lot);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        lotService.deleteById(id);
    }

}
