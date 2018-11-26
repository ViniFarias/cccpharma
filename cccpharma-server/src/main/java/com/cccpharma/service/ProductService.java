package com.cccpharma.service;

import com.cccpharma.domain.orm.Product;

public interface ProductService {

    Product getById(String id);
    Product save(Product product);
}
