package com.cccpharma.soldProduct;

import com.cccpharma.lot.Lot;
import com.cccpharma.lot.LotService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

/**
 * The {@code SoldProductServiceImpl} class implements the {@code SoldProduct} methods with the business rule.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see SoldProduct
 */
@Service
@NoArgsConstructor
@AllArgsConstructor
public class SoldProductServiceImpl implements SoldProductService {

    /**
     * The interface for operations on the sold product repository.
     */
    @Autowired
    private SoldProductRepository soldProductRepository;

    /**
     * The lot operations service.
     */
    @Autowired
    private LotService lotService;

    /**
     * Returns all instances of sold products.
     *
     * @return all sold products
     */
    public List<SoldProduct> findAll() {

        Iterable<SoldProduct> soldProducts = soldProductRepository.findAll();
        List<SoldProduct> soldProductsResult = new ArrayList<>();

        for(SoldProduct soldProduct : soldProducts) {
            soldProductsResult.add(soldProduct);
        }

        return soldProductsResult;
    }

    /**
     * Retrieves an sold product by its id.
     *
     * @param id must not be {@literal null}
     * @return the entity with the given id or {@literal null} if none found
     * @throws NullPointerException in case the given id is null.
     */
    public SoldProduct findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Sold product id is null!");
        }
        if(!soldProductRepository.existsById(id)) {
            throw new RuntimeException("Sold product not found!");
        }

        return soldProductRepository.findById(id).get();
    }

    /**
     * Saves a given sold product.
     * Decreases the quantity of product sold from the corresponding lots.
     *
     * @param soldProduct must not be {@literal null}
     * @return the saved sold product, it will never be {@literal null}
     * @throws NullPointerException in case the given sold product or its attributes are null.
     */
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
        List<Lot> availableLots = lotService.findAvailableLotsByProductIdAndExpirationDateGraterThan(soldProduct.getProduct().getBarcode(), soldProduct.getSale().getSaleDate());
        int index = 0;

        while(soldProductsQuantity != 0) {

            Lot lot = availableLots.get(index);
            int lotAvailableProductsQuantity = lot.getAvailableProductsQuantity();

            if(lotAvailableProductsQuantity >= soldProductsQuantity) {
                lot.setAvailableProductsQuantity(lotAvailableProductsQuantity - soldProductsQuantity);
                soldProductsQuantity = 0;
            }
            else {
                soldProductsQuantity -= lotAvailableProductsQuantity;
                lot.setAvailableProductsQuantity(0);
            }

            lotService.save(lot);
            index++;
        }

        return soldProductRepository.save(soldProduct);
    }

    /**
     * Deletes a sold product by its id.
     * Increases the quantity of product sold from the corresponding lots.
     *
     * @param id must not be {@literal null}
     * @throws NullPointerException in case the given id is null.
     * @throws RuntimeException in case the sold product is not found.
     */
    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Sold product id is null!");
        }
        if(!soldProductRepository.existsById(id)) {
            throw new RuntimeException("Sold product not found!");
        }

        SoldProduct soldProduct = soldProductRepository.findById(id).get();

        int soldProductsQuantity = soldProduct.getProductsQuantity();
        List<Lot> availableLots = lotService.findLotsByProductIdAndExpirationDateGreaterThan(soldProduct.getProduct().getBarcode(), soldProduct.getSale().getSaleDate());
        int index = 0;

        while(soldProductsQuantity != 0) {

            Lot lot = availableLots.get(index);
            int lotProductsQuantity = lot.getProductsQuantityTotal();
            int lotAvailableProductsQuantity = lot.getAvailableProductsQuantity();
            int itemsAddQuantity = lotProductsQuantity - lotAvailableProductsQuantity;

            if(itemsAddQuantity >= soldProductsQuantity) {
                lot.setAvailableProductsQuantity(lotAvailableProductsQuantity + soldProductsQuantity);
                soldProductsQuantity = 0;
            }
            else {
                soldProductsQuantity -= itemsAddQuantity;
                lot.setAvailableProductsQuantity(soldProductsQuantity);
            }

            lotService.save(lot);
            index++;
        }

        soldProductRepository.deleteById(id);
    }

}
