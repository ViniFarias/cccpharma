package com.cccpharma.domain.repository;

import com.cccpharma.domain.orm.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {}
