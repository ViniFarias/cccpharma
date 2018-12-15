package com.cccpharma.soldProduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldProductRepository extends CrudRepository<SoldProduct, Long> {}
