package com.cccpharma.service;

import com.cccpharma.domain.orm.SoldProduct;

import java.util.List;

public interface SoldProductService {

    SoldProduct findById(Long id);
    SoldProduct save(SoldProduct product);
    void deleteById(Long id);
    List<SoldProduct> findAll();
}
