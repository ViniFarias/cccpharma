package com.cccpharma.service;

import com.cccpharma.domain.orm.Lot;
import com.cccpharma.domain.orm.SoldProduct;
import com.cccpharma.domain.repository.SoldProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static java.util.Objects.isNull;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class SoldProductServiceImpl implements SoldProductService {

    @Autowired
    private SoldProductRepository soldProductRepository;

    @Autowired
    private LotService lotService;

    public List<SoldProduct> findAll() {

        Iterable<SoldProduct> soldProducts = soldProductRepository.findAll();
        List<SoldProduct> soldProductsResult = new ArrayList<>();

        for(SoldProduct soldProduct : soldProducts) {
            soldProductsResult.add(soldProduct);
        }

        return soldProductsResult;
    }

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

        if(isNull(soldProduct)) {
            throw new NullPointerException("Sold product is null!");
        }
        if(isNull(soldProduct.getProduct())) {
            throw new NullPointerException("Product is null!");
        }
        if(isNull(soldProduct.getProductsQuantity())) {
            throw new NullPointerException("Products quantity is null!");
        }
        if(isNull(soldProduct.getSale())) {
            throw new NullPointerException("Sale is null!");
        }

        int soldProductsQuantity = soldProduct.getProductsQuantity();
        List<Lot> availableLots = lotService.findValidLotsByProductIdAndProductsQuantityGreaterThanZero(soldProduct.getProduct().getBarcode());
        int index = 0;

        while(soldProductsQuantity != 0) {

            Lot lot = availableLots.get(index);
            int lotProductsQuantity = lot.getProductsQuantity();

            if(lotProductsQuantity >= soldProductsQuantity) {
                lot.setProductsQuantity(lotProductsQuantity - soldProductsQuantity);
                soldProductsQuantity = 0;
            }
            else {
                soldProductsQuantity -= lotProductsQuantity;
                lot.setProductsQuantity(0);
            }

            lotService.save(lot);
            index++;
        }

        return soldProductRepository.save(soldProduct);
    }

    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Sold product id is null!");
        }
        if(!soldProductRepository.existsById(id)) {
            throw new RuntimeException("Sold product not found!");
        }

        soldProductRepository.deleteById(id);
    }

}
