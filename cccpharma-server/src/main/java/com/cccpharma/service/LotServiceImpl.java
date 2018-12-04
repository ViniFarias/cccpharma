package com.cccpharma.service;

import com.cccpharma.domain.orm.Lot;
import com.cccpharma.domain.repository.LotRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class LotServiceImpl implements LotService {

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    public List<Lot> findAll() {

        Iterable<Lot> lots = lotRepository.findAll();
        List<Lot> lotsResult = new ArrayList<>();

        for(Lot lot : lots) {
            lotsResult.add(lot);
        }

        return lotsResult;
    }

    public Lot findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Lot id is null!");
        }
        if(!lotRepository.existsById(id)) {
            throw new RuntimeException("Lot not found!");
        }

        return lotRepository.findById(id).get();
    }

    public List<Lot> findValidLotsByProductIdAndProductsQuantityGreaterThanZero(String productId) {
        if(isNull(productId)) {
            throw new NullPointerException("Product id is null!");
        }

        return lotRepository.findValidLotsByProductIdAndProductsQuantityGreaterThanZero(productId);
    }

    public List<Lot> findValidLotsByProductId(String productId) {
        if(isNull(productId)) {
            throw new NullPointerException("Product id is null!");
        }

        return lotRepository.findValidLotsByProductId(productId);
    }


    public Lot save(Lot lot) {

        if(isNull(lot.getExpirationDate())) {
            throw new NullPointerException("Expiration date is null!");
        }
        if(isNull(lot.getProductsQuantity())) {
            throw new NullPointerException("Products quantity is null!");
        }
        if(isNull(lot.getProduct())) {
            throw new NullPointerException("Product is null!");
        }

        if(!productServiceImpl.existsById(lot.getProduct().getBarcode())) {
            throw new RuntimeException("Product not found!");
        }

        return lotRepository.save(lot);
    }

    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Lot id is null!");
        }
        if(!lotRepository.existsById(id)) {
            throw new RuntimeException("Lot not found!");
        }

        lotRepository.deleteById(id);
    }
}
