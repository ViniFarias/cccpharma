package com.cccpharma.api;

import com.cccpharma.domain.orm.Lot;
import com.cccpharma.service.LotService;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Lot> findAll() {
        return lotService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Lot findById(@PathVariable Long id) {
        return lotService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Lot save(@RequestBody Lot lot) {
        return lotService.save(lot);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        lotService.deleteById(id);
    }
}
