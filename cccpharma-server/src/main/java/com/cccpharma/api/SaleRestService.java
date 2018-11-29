package com.cccpharma.api;

import com.cccpharma.domain.orm.Sale;
import com.cccpharma.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SaleRestService {

    @Autowired
    private SaleService saleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Sale> findAll() {
        return saleService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Sale findById(@PathVariable Long id) {
        return saleService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sale save(@RequestBody Sale sale) {
        return saleService.save(sale);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        saleService.deleteById(id);
    }

}
