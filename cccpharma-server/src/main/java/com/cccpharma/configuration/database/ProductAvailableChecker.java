package com.cccpharma.configuration.database;

import com.cccpharma.product.Product;
import com.cccpharma.lot.LotService;
import com.cccpharma.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * The {@code ProductAvailableChecker} class is responsible for performing tasks
 * that update the products availability.
 * These tasks are performed at a scheduled time.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 */
@Component
public class ProductAvailableChecker {

    /**
     * The lots operations service.
     */
    @Autowired
    LotService lotService;


    /**
     * The products operations service.
     */
    @Autowired
    ProductService productService;

    /**
     * The time zone.
     * Configured for the America/Recife region.
     */
    private static final String TIME_ZONE = "America/Recife";

    /**
     * Updates product availability according to expiration date.
     * Updates the availability of a product to false when all of its lots are expired.
     * It Runs every day at 23:59:59 in the defined time zone.
     */
    @Scheduled(cron = "59 59 23 * * *", zone = TIME_ZONE)
    public void updatesProductsAvailableByExpirationDate(){

        System.out.println("\nUpdate of products availability by expiration date started");

        List<Product> products = productService.findAll();

        for(Product product : products) {
            int validLotsQuantity = lotService.findValidLotsByProductId(product.getBarcode()).size();

            if(validLotsQuantity == 0) {
                product.setAvailable(false);
            }
            else {
                product.setAvailable(true);
            }

            productService.save(product);
        }

        System.out.println("Update of products availability by expiration date finished");
    }

    /**
     * Updates the availability of the product according to its quantity.
     * Updates the availability of a product to false when its quantity is zero.
     * It runs every ten seconds in the defined time zone.
     */
    @Scheduled(cron = "*/10 * * * * *", zone = TIME_ZONE)
    public void updatesProductsAvailableByQuantity(){

        System.out.println("\nUpdate of products quantity by expiration date started");

        List<Product> products = productService.findAll();

        for(Product product : products) {
            int availableLotsQuantity = lotService.findAvailableLotsByProductId(product.getBarcode()).size();

            if(availableLotsQuantity == 0) {
                product.setAvailable(false);
            }
            else {
                product.setAvailable(true);
            }

            productService.save(product);
        }

        System.out.println("Update of products quantity by expiration date finished");
    }

}
