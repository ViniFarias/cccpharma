package com.cccpharma.sale;

import com.cccpharma.soldProduct.SoldProduct;
import com.cccpharma.soldProduct.SoldProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

/**
 * The {@code SaleServiceImpl} class implements the {@code SaleService} methods with the business rule.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see SaleService
 */
@Service
@NoArgsConstructor
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {

    /**
     * The interface for operations on the sale repository.
     */
    @Autowired
    private SaleRepository saleRepository;

    /**
     * The sold products operations service.
     */
    @Autowired
    private SoldProductService soldProductService;

    /**
     * Returns all instances of sales.
     *
     * @return all sales
     */
    public List<Sale> findAll() {

        Iterable<Sale> sales = saleRepository.findAll();
        List<Sale> salesResult = new ArrayList<>();

        for(Sale sale : sales) {
            salesResult.add(sale);
        }

        return salesResult;
    }

    /**
     * Retrieves an sale by its id.
     *
     * @param id must not be {@literal null}
     * @return the entity with the given id or {@literal null} if none found
     * @throws NullPointerException in case the given id is null
     * @throws RuntimeException in case the sale is not found
     */
    public Sale findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Sale id is null!");
        }
        if(!saleRepository.existsById(id)) {
            throw new RuntimeException("Sale not found!");
        }

        return saleRepository.findById(id).get();
    }

    /**
     * Saves a given sale.
     * Saves the sold products in the sale.
     *
     * @param sale must not be {@literal null}
     * @return the saved sale, it will never be {@literal null}
     * @throws NullPointerException in case the given sale or its attributes are null
     */
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

    /**
     * Deletes a sale by its id.
     * Deletes the sold products in the sale.
     *
     * @param id must not be {@literal null}
     * @throws NullPointerException in case the given id is null
     * @throws RuntimeException in case the sale is not found
     */
    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Sale id is null!");
        }
        if(!saleRepository.existsById(id)) {
            throw new RuntimeException("Sale not found!");
        }

        Sale sale = saleRepository.findById(id).get();

        for(SoldProduct soldProduct : sale.getSoldProducts()) {
            soldProductService.deleteById(soldProduct.getId());
        }

        saleRepository.deleteById(id);
    }
}
