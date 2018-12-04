package com.cccpharma.domain.repository;

import com.cccpharma.domain.orm.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Long> {}
