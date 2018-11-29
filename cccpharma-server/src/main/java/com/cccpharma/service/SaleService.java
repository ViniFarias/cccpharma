package com.cccpharma.service;

import com.cccpharma.domain.orm.Sale;
import java.util.List;

public interface SaleService {
    Sale findById(Long id);
    Sale save(Sale sale);
    List<Sale> findAll();
    void deleteById(Long id);
}
