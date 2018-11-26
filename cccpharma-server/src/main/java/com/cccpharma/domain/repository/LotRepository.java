package com.cccpharma.domain.repository;

import com.cccpharma.domain.orm.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends CrudRepository<Lot, Long> {}
