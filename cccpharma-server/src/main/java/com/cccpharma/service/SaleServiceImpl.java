package com.cccpharma.service;

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

        if(isNull(sale.getSoldProducts())) {
            throw new NullPointerException("List of sold products is null!");
        }
        if(isNull(sale.getSaleDate())) {
            throw new NullPointerException("Sale date is null!");
        }
        if(isNull(sale.getValue())) {
            throw new NullPointerException("Sale value is null!");
        }

        SoldProductServiceImpl soldProductService = new SoldProductServiceImpl();

        for(SoldProduct soldProduct : sale.getSoldProducts()) {
            soldProductService.save(soldProduct);
        }

        return saleRepository.save(sale);
    }

    public Sale findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Sale id is null!");
        }
        if(!saleRepository.existsById(id)) {
            throw new RuntimeException("Sale not found!");
        }

        return saleRepository.findById(id).get();
    }

    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Sale id is null!");
        }
        if(!saleRepository.existsById(id)) {
            throw new RuntimeException("Sale not found!");
        }

        saleRepository.deleteById(id);
    }
}
