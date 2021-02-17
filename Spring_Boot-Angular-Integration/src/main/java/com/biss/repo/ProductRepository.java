package com.biss.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biss.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
