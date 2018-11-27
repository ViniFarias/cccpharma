package com.cccpharma.service;

import com.cccpharma.domain.orm.Product;
import com.cccpharma.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product getById(String id) {
        Product product = productRepository.findById(id).get();
        if(product == null) {
            throw new RuntimeException("Product not found!");
        }
        return product;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }


//    @Override
//    public Product update(Product product) {
//        productRepository.de
//        return null;
//    }

}
