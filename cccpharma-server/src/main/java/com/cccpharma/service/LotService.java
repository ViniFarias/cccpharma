package com.cccpharma.service;


import com.cccpharma.domain.orm.Lot;

import java.util.Date;
import java.util.List;

public interface LotService {

    Lot findById(Long id);
    Lot save(Lot lot);
    List<Lot> findAll();
    void deleteById(Long id);
}
