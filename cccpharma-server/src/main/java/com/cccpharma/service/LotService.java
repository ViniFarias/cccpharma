package com.cccpharma.service;


import com.cccpharma.domain.orm.Lot;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface LotService {

    Lot findById(Long id);
    Lot save(Lot lot);
    List<Lot> findAll();
    List<Lot> findValidLotsByProductId(String productId);
    List<Lot> findValidLotsByProductIdAndExpirationDateGreaterThan(String productId, Date date);
    List<Lot> findLotsByProductIdAndExpirationDateGreaterThan(String productId, Date date);
    void deleteById(Long id);
}
