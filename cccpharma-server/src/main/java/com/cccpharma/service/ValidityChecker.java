package com.cccpharma.service;

import com.cccpharma.domain.orm.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidityChecker {

    @Autowired
    LotService lotService;

    private static final String TIME_ZONE = "America/Brasilia";
    private final long SECOND = 1000;
    private final long MINUTE = SECOND * 60;
    private final long HOUR = MINUTE * 60;

//    ta verificando todo dia de 12h
    @Scheduled(cron = "0 0 12 * * *", zone = TIME_ZONE)
    public void verifyValidityForHour(String id){
        List<Lot> lots = lotService.findInvalidLotsByProductId(id);
        if(lots.size() > 0) {
            for(Lot lot : lots){
                lot.getProduct().setAvailable(false);
            }
        }
    }
}
