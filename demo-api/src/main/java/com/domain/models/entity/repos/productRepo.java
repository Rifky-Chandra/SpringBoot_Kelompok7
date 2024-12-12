package com.domain.models.entity.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.domain.models.entity.Product;

public interface productRepo extends CrudRepository<Product, Long> {

    List<Product> findByNameContains(String name);
    
}
