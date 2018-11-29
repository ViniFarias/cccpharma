package com.cccpharma.service;

import com.cccpharma.domain.orm.Lot;
import com.cccpharma.domain.orm.Sale;
import com.cccpharma.domain.orm.SoldProduct;
import com.cccpharma.domain.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> findAll() {
        Iterable<Sale> sales = saleRepository.findAll();
        List<Sale> salesResult = new ArrayList<>();

        for(Sale sale : sales) {
            salesResult.add(sale);
        }

        return salesResult;
    }

    public Sale save(Sale sale) {

        return saleRepository.save(sale);
    }

    public Sale findById(Long id) {
        if(!saleRepository.existsById(id)) {
            throw new RuntimeException("Sale not found!");
        }

        return saleRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        if(!saleRepository.existsById(id)) {
            throw new RuntimeException("Sale not found!");
        }

        saleRepository.deleteById(id);
    }
}
