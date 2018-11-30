package com.cccpharma.domain.repository;

import com.cccpharma.domain.orm.Item;
import com.cccpharma.domain.orm.SoldProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<SoldProduct, Long> {}
