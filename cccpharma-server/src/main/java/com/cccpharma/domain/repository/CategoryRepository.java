package com.cccpharma.domain.repository;

import com.cccpharma.domain.orm.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {}
