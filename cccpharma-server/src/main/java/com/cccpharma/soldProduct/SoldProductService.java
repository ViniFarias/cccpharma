package com.cccpharma.soldProduct;

import java.util.List;

public interface SoldProductService {

    SoldProduct findById(Long id);
    SoldProduct save(SoldProduct product);
    void deleteById(Long id);
    List<SoldProduct> findAll();
}
