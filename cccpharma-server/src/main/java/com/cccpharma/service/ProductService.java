package com.cccpharma.service;

import com.cccpharma.domain.orm.Product;

import java.util.List;

public interface ProductService {

    Product findById(String id);
    Product save(Product product);
    void deleteById(String id);
    List<Product> findAll();
    List<Product> findAllByName(String name);
    List<Product> findAllByAvailable();
    List<Product> findAllByManufacturer(String manufactorer);
    double productPrice(String id);
    boolean existsById(String id);
}
