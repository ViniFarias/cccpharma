package com.cccpharma.service;

import com.cccpharma.domain.orm.Product;
import com.cccpharma.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {

        Iterable<Product> products = productRepository.findAll();
        List<Product> productsResult = new ArrayList<>();

        for(Product product : products) {
            productsResult.add(product);
        }

        return productsResult;
    }

    public List<Product> findAllByName(String name){

        if(isNull(name)){
            throw new RuntimeException("Product not found!");
        }

        return productRepository.findAllByName(name);
    }

    public List<Product> findAllByAvailable(){

        Iterable<Product> products = productRepository.findAll();
        List<Product> productsResult = new ArrayList<>();

        for(Product product : products){
            if(product.isAvailable()) {
                productsResult.add(product);
            }
        }
        return productsResult;
    }

    public List<Product> findAllByManufacturer(String manufacturer){

        if(isNull(manufacturer)){
            throw new RuntimeException("Product not a found!");
        }

        return productRepository.findAllByManufacturer(manufacturer);
    }

    public Product findById(String id) {

        if(isNull(id)) {
            throw new NullPointerException("Product id is null!");
        }
        if(!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found!");
        }
        return productRepository.findById(id).get();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    public boolean existsById(String id) {
        return productRepository.existsById(id);
    }

    public double productPrice(String id) {
        this.exception(id);
        return productRepository.findById(id).get().getPrice();
    }

    private void exception(String id){
        if (isNull(id)) {
            throw new NullPointerException("Product id is null!");
        }
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found!");
        }
    }
}
