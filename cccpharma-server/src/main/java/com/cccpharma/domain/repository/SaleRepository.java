package com.cccpharma.domain.repository;

import com.cccpharma.domain.orm.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Long> {}
