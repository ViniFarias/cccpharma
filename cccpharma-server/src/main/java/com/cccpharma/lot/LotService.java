package com.cccpharma.lot;

import java.util.Date;
import java.util.List;

public interface LotService {

    Lot findById(Long id);
    Lot save(Lot lot);
    List<Lot> findAll();
    List<Lot> findValidLotsByProductId(String productId);
    List<Lot> findAvailableLotsByProductIdAndExpirationDateGraterThan(String productId, Date date);
    List<Lot> findLotsByProductIdAndExpirationDateGreaterThan(String productId, Date date);
    List<Lot> findAvailableLotsByProductId(String productId);
    void deleteById(Long id);
}
