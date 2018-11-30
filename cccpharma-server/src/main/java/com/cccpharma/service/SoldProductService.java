package com.cccpharma.service;

import com.cccpharma.domain.orm.SoldProduct;

public interface SoldProductService {

    SoldProduct findById(Long id);
    SoldProduct save(SoldProduct product);
    void deleteById(Long id);
}
