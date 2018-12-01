package com.cccpharma.service;

import com.cccpharma.domain.orm.Sale;
import com.cccpharma.domain.orm.SoldProduct;
import com.cccpharma.domain.repository.SaleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SoldProductServiceImpl soldProductService;

    public List<Sale> findAll() {

        Iterable<Sale> sales = saleRepository.findAll();
        List<Sale> salesResult = new ArrayList<>();

        for(Sale sale : sales) {
            salesResult.add(sale);
        }

        return salesResult;
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

        Sale saleSaved = saleRepository.save(sale);

        for(SoldProduct soldProduct : sale.getSoldProducts()) {
            soldProduct.setSale(saleSaved);
            soldProductService.save(soldProduct);
        }

        return saleSaved;
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
