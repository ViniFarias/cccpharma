package com.cccpharma.api;

import com.cccpharma.domain.orm.Product;
import com.cccpharma.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductRestService {

    @Autowired
    private ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getById(@PathVariable  String id) {
        return productService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
         productService.delete(id);
    }
}
