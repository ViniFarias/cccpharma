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
    }

    @Override
    public Product save(Product product) {
    }

}
