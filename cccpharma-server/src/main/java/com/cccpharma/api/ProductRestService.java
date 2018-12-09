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

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable  String id) {
        return productService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteById(@RequestBody Product product) {
         productService.deleteById(product.getBarcode());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}/price", method = RequestMethod.GET)
    public Double productPrice(@PathVariable String id) { return productService.productPrice(id); }

    @GetMapping(value = "/available")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllByAvailable() {
        return productService.findAllByAvailable();
    }


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/name/{name}")
    public List<Product> findAllByName(@PathVariable String name){
        return productService.findAllByName(name);
    }

    @GetMapping(value = "/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllByManufacturer(@PathVariable String manufacturer){
        return productService.findAllByManufacturer(manufacturer);
    }
}
