package com.cccpharma.lot;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

/**
 * Interface for CRUD operations on a repository for the {@code Lot} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see Lot
 */
@Repository
public interface LotRepository extends CrudRepository<Lot, Long> {

    /**
     * Retrieves the lots with the given product id and that have the expiration date greater
     * than the current date of the system.
     *
     * @param productId must not be {@literal null}
     * @return the lots returned by the database query or {@literal null} if none found
     */
    @Query(value =
            "SELECT * " +
            "FROM lot " +
            "WHERE expiration_date > curdate() " +
                "AND product_id = :productId " +
            "ORDER BY expiration_date", nativeQuery = true)
    List<Lot> findValidLotsByProductId(@Param("productId") String productId);

    /**
     * Retrieves the lot with the given product id,
     * which have the expiration date greater than the given date
     * and which have the quantity of available products greater than 0.
     *
     * @param productId must not be {@literal null}
     * @param date must not be {@literal null}
     * @return the lots returned by the database query or {@literal null} if none found
     */
    @Query(value =
            "SELECT * " +
            "FROM lot " +
            "WHERE expiration_date > :date " +
                    "AND available_products_quantity > 0 " +
                    "AND product_id = :productId " +
            "ORDER BY expiration_date", nativeQuery = true)
    List<Lot> findAvailableLotsByProductIdAndExpirationDateGraterThan(@Param("productId") String productId, @Param("date") Date date);

    /**
     * Retrieves the lots with the given product id
     * and which have the quantity of available products greater than 0.
     *
     * @param productId must not be {@literal null}
     * @return the lots returned by the database query or {@literal null} if none found
     */
    @Query(value =
            "SELECT * " +
            "FROM lot " +
            "WHERE expiration_date > curdate() " +
                "AND available_products_quantity > 0 " +
                "AND product_id = :productId " +
            "ORDER BY expiration_date", nativeQuery = true)
    List<Lot> findAvailableLotsByProductId(@Param("productId") String productId);

    /**
     * Retrieves the lot with the given product id
     * and which have the expiration date greater than the given date.
     *
     * @param productId must not be {@literal null}
     * @param date must not be {@literal null}
     * @return the lots returned by the database query or {@literal null} if none found
     */
    @Query(value =
            "SELECT * " +
            "FROM lot " +
            "WHERE expiration_date > :date " +
                "AND product_id = :productId " +
            "ORDER BY expiration_date", nativeQuery = true)
    List<Lot> findLotsByProductIdAndExpirationDateGreaterThan(@Param("productId") String productId,
                                                              @Param("date") Date date);
}
