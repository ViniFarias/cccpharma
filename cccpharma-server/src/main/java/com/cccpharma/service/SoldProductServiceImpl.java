package com.cccpharma.service;

import com.cccpharma.domain.orm.SoldProduct;
import com.cccpharma.domain.repository.SoldProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class SoldProductServiceImpl implements SoldProductService {

    @Autowired
    private SoldProductRepository soldProductRepository;

    public SoldProduct findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Sold product id is null!");
        }
        if(!soldProductRepository.existsById(id)) {
            throw new RuntimeException("Sold product not found!");
        }

        return soldProductRepository.findById(id).get();
    }

    public SoldProduct save(SoldProduct soldProduct) {

        if(isNull(soldProduct.getProduct())) {
            throw new NullPointerException("Product is null!");
        }
        if(isNull(soldProduct.getProductsQuantity())) {
            throw new NullPointerException("Products quantity is null!");
        }
        if(isNull(soldProduct.getSale())) {
            throw new NullPointerException("Sale is null!");
        }

        return soldProductRepository.save(soldProduct);
    }

    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Sold product id is null!");
        }
        soldProductRepository.deleteById(id);
    }

}