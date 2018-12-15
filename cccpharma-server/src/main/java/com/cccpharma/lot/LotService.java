package com.cccpharma.lot;

import java.util.Date;
import java.util.List;

/**
 * Interface for service operations on a repository for the {@code Lot} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see Lot
 */
public interface LotService {

    /**
     * Retrieves a lot by its id.
     *
     * @param id must not be {@literal null}
     * @return the lot with the given id or {@literal null} if none found
     */
    Lot findById(Long id);

    /**
     * Saves a given lot.
     *
     * @param lot must not be {@literal null}
     * @return the saved lot, it will never be {@literal null}
     */
    Lot save(Lot lot);

    /**
     * Returns all instances of lots.
     *
     * @return all lots
     */
    List<Lot> findAll();

    /**
     * Retrieves the lots with the given product id and that have the expiration date greater
     * than the current date of the system.
     *
     * @param productId must not be {@literal null}
     * @return the valid lots or {@literal null} if none found
     */
    List<Lot> findValidLotsByProductId(String productId);

    /**
     * Retrieves the lot with the given product id,
     * which have the expiration date greater than the given date
     * and which have the quantity of available products greater than 0.
     *
     * @param productId must not be {@literal null}
     * @param date must not be {@literal null}
     * @return the valid lots or {@literal null} if none found
     */
    List<Lot> findAvailableLotsByProductIdAndExpirationDateGraterThan(String productId, Date date);

    /**
     * Retrieves the lot with the given product id,
     * which have the expiration date greater than the given date
     * and which have the quantity of available products greater than 0.
     *
     * @param productId must not be {@literal null}
     * @param date must not be {@literal null}
     * @return the lots returned by the database query or {@literal null} if none found
     */
    List<Lot> findLotsByProductIdAndExpirationDateGreaterThan(String productId, Date date);

    /**
     * Retrieves the lot with the given product id
     * and which have the quantity of available products greater than 0.
     *
     * @param productId must not be {@literal null}
     * @return the available lots or {@literal null} if none found
     */
    List<Lot> findAvailableLotsByProductId(String productId);

    /**
     * Deletes a lot by its id.
     *
     * @param id must not be {@literal null}
     */
    void deleteById(Long id);
}
