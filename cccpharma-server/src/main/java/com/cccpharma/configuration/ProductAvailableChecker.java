package com.cccpharma.configuration;

import com.cccpharma.domain.orm.Product;
import com.cccpharma.service.LotService;
import com.cccpharma.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductAvailableChecker {

    @Autowired
    LotService lotService;

    @Autowired
    ProductService productService;

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @Scheduled(cron = "59 59 23 * * *", zone = TIME_ZONE)
    public void updatesProductsAvailableByExpirationDate(){

        System.out.println("Update of product availability by expiration date started");

        List<Product> products = productService.findAll();

        for(Product product : products) {
            int validLotsQuantity = lotService.findValidLotsByProductId(product.getBarcode()).size();

            if(validLotsQuantity == 0) {
                product.setAvailable(false);
                productService.save(product);
            }
        }

        System.out.println("Update of product availability by expiration date finished");
    }

    @Scheduled(cron = "*/20 * * * * *", zone = TIME_ZONE)
    public void updatesProductsAvailableByQuantity(){

        System.out.println("Update of product quantity by expiration date finished");

        List<Product> products = productService.findAll();

        for(Product product : products) {
            int availableLotsQuantity = lotService.findAvailableLotsByProductId(product.getBarcode()).size();

            if(availableLotsQuantity == 0) {
                product.setAvailable(false);
                productService.save(product);
            }
        }

        System.out.println("Update of product quantity by expiration date finished");
    }

}
