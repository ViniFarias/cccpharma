package com.cccpharma.sale;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for CRUD operations on a repository for the {@code Sale} type.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 * @see Sale
 */
@Repository
public interface SaleRepository extends CrudRepository<Sale, Long> {}
