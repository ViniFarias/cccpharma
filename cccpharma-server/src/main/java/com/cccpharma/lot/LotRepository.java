package com.cccpharma.lot;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface LotRepository extends CrudRepository<Lot, Long> {

    @Query(value =
            "SELECT * " +
            "FROM lot " +
            "WHERE expiration_date > curdate() " +
                "AND product_id = :productId " +
            "ORDER BY expiration_date", nativeQuery = true)
    List<Lot> findValidLotsByProductId(@Param("productId") String productId);

    @Query(value =
            "SELECT * " +
            "FROM lot " +
            "WHERE expiration_date > :date " +
                    "AND available_products_quantity > 0 " +
                    "AND product_id = :productId " +
            "ORDER BY expiration_date", nativeQuery = true)
    List<Lot> findAvailableLotsByProductIdAndExpirationDateGraterThan(@Param("productId") String productId, @Param("date") Date date);

    @Query(value =
            "SELECT * " +
            "FROM lot " +
            "WHERE expiration_date > curdate() " +
                "AND available_products_quantity > 0 " +
                "AND product_id = :productId " +
            "ORDER BY expiration_date", nativeQuery = true)
    List<Lot> findAvailableLotsByProductId(@Param("productId") String productId);

    @Query(value =
            "SELECT * " +
            "FROM lot " +
            "WHERE expiration_date > :date " +
                "AND product_id = :productId " +
            "ORDER BY expiration_date", nativeQuery = true)
    List<Lot> findLotsByProductIdAndExpirationDateGreaterThan(@Param("productId") String productId,
                                                              @Param("date") Date date);
}
