package com.cccpharma.service;

import com.cccpharma.domain.orm.Product;

import java.util.List;

public interface ProductService {

    Product findById(String id);
    Product save(Product product);
    void deleteById(String id);
    List<Product> findAll();
    List<Product> productListByName(String name);
    List<Product> productListByAvailable();
    List<Product> productListByManufacturer(String manufactorer);
    double productPrice(String id);
    boolean existsById(String id);
}
