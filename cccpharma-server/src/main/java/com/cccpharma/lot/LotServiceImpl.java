package com.cccpharma.lot;

import com.cccpharma.product.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.Objects.isNull;

/**
 * The {@code LotServiceImpl} class implements the {@code LotService} methods with the business rule.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see LotService
 */
@Service
@AllArgsConstructor
@NoArgsConstructor
public class LotServiceImpl implements LotService {

    /**
     * The interface for operations on the lot repository.
     */
    @Autowired
    private LotRepository lotRepository;

    /**
     * The interface for products service operations.
     */
    @Autowired
    private ProductService productService;

    /**
     * Returns all instances of lots.
     *
     * @return all lots
     */
    public List<Lot> findAll() {

        Iterable<Lot> lots = lotRepository.findAll();
        List<Lot> lotsResult = new ArrayList<>();

        for(Lot lot : lots) {
            lotsResult.add(lot);
        }

        return lotsResult;
    }

    /**
     * Retrieves a lot by its id.
     *
     * @param id must not be {@literal null}
     * @return the product with the given id or {@literal null} if none found
     * @throws NullPointerException in case the given id is null
     * @throws RuntimeException in case the lot is not found
     */
    public Lot findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Lot id is null!");
        }
        if(!lotRepository.existsById(id)) {
            throw new RuntimeException("Lot not found!");
        }

        return lotRepository.findById(id).get();
    }

    /**
     * Retrieves the lot with the given product id
     * and which have the quantity of available products greater than 0.
     *
     * @param productId must not be {@literal null}
     * @return the available lots or {@literal null} if none found
     * @throws NullPointerException in case the given id is null
     */
    public List<Lot> findAvailableLotsByProductId(String productId) {
        if(isNull(productId)) {
            throw new NullPointerException("Product id is null!");
        }

        return lotRepository.findAvailableLotsByProductId(productId);
    }

    /**
     * Retrieves the lot with the given product id,
     * which have the expiration date greater than the given date
     * and which have the quantity of available products greater than 0.
     *
     * @param productId must not be {@literal null}
     * @param date must not be {@literal null}
     * @return the valid lots or {@literal null} if none found
     * @throws NullPointerException in case the given product id or date is null
     */
    public List<Lot> findAvailableLotsByProductIdAndExpirationDateGraterThan(String productId, Date date) {
        if(isNull(productId)) {
            throw new NullPointerException("Product id is null!");
        }
        if(isNull(date)) {
            throw new NullPointerException("Date is null!");
        }

        return lotRepository.findAvailableLotsByProductIdAndExpirationDateGraterThan(productId, date);
    }

    /**
     * Retrieves the lots with the given product id and that have the expiration date greater
     * than the current date of the system.
     *
     * @param productId must not be {@literal null}
     * @return the valid lots or {@literal null} if none found
     * @throws NullPointerException in case the given product id is null
     */
    public List<Lot> findValidLotsByProductId(String productId) {
        if(isNull(productId)) {
            throw new NullPointerException("Product id is null!");
        }

        return lotRepository.findValidLotsByProductId(productId);
    }

    /**
     * Retrieves the lot with the given product id,
     * which have the expiration date greater than the given date
     * and which have the quantity of available products greater than 0.
     *
     * @param productId must not be {@literal null}
     * @param date must not be {@literal null}
     * @return the lots returned by the database query or {@literal null} if none found
     * @throws NullPointerException in case the given product id or date is null
     */
    public List<Lot> findLotsByProductIdAndExpirationDateGreaterThan(String productId, Date date) {
        if(isNull(productId)) {
            throw new NullPointerException("Product id is null!");
        }
        if(isNull(date)) {
            throw new NullPointerException("Date is null!");
        }

        return lotRepository.findLotsByProductIdAndExpirationDateGreaterThan(productId, date);
    }


    /**
     * Saves a given lot.
     *
     * @param lot must not be {@literal null}
     * @return the saved lot, it will never be {@literal null}
     * @throws NullPointerException in case the given lot or its attributes are null
     * @throws RuntimeException in case the product is not found
     */
    public Lot save(Lot lot) {

        if(isNull(lot.getExpirationDate())) {
            throw new NullPointerException("Expiration date is null!");
        }
        if(isNull(lot.getProductsQuantityTotal())) {
            throw new NullPointerException("Products quantity is null!");
        }
        if(isNull(lot.getProduct())) {
            throw new NullPointerException("Product is null!");
        }

        if(!productService.existsById(lot.getProduct().getBarcode())) {
            throw new RuntimeException("Product not found!");
        }

        return lotRepository.save(lot);
    }

    /**
     * Deletes a lot by its id.
     *
     * @param id must not be {@literal null}
     * @throws NullPointerException in case the given id is null
     * @throws RuntimeException in case the lot is not found
     */
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
