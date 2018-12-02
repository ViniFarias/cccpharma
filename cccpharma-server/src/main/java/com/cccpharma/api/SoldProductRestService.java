package com.cccpharma.api;

import com.cccpharma.domain.orm.SoldProduct;
import com.cccpharma.service.SoldProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/soldproducts")
public class SoldProductRestService {

    @Autowired
    private SoldProductService soldProductService;

    @GetMapping
    public List<SoldProduct> findAll() {
        return soldProductService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SoldProduct save(@RequestBody SoldProduct soldProduct) {
        return soldProductService.save(soldProduct);
    }
}
