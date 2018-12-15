package com.cccpharma.configuration.database;

import com.cccpharma.product.Product;
import com.cccpharma.lot.LotService;
import com.cccpharma.product.ProductService;
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

    private static final String TIME_ZONE = "America/Recife";

    @Scheduled(cron = "59 59 23 * * *", zone = TIME_ZONE)
    public void updatesProductsAvailableByExpirationDate(){

        System.out.println("\nUpdate of products availability by expiration date started");

        List<Product> products = productService.findAll();

        for(Product product : products) {
            int validLotsQuantity = lotService.findValidLotsByProductId(product.getBarcode()).size();

            if(validLotsQuantity == 0) {
                product.setAvailable(false);
                productService.save(product);
            }
        }

        System.out.println("Update of products availability by expiration date finished");
    }

    @Scheduled(cron = "*/10 * * * * *", zone = TIME_ZONE)
    public void updatesProductsAvailableByQuantity(){

        System.out.println("\nUpdate of products quantity by expiration date started");

        List<Product> products = productService.findAll();

        for(Product product : products) {
            int availableLotsQuantity = lotService.findAvailableLotsByProductId(product.getBarcode()).size();

            if(availableLotsQuantity == 0) {
                product.setAvailable(false);
                productService.save(product);
            }
        }

        System.out.println("Update of products quantity by expiration date finished");
    }

}
