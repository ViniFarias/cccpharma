package com.cccpharma.api;

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

    @Autowired
    private ProductResourceAssembler productResourceAssembler;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductResource getById(@PathVariable  String id) {
        return productResourceAssembler.toResource(productService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ProductResource save(@RequestBody ProductResource productResource) {
        return productResourceAssembler.toResource(productService.save(productResourceAssembler.toDomain(productResource)));
    }
}
