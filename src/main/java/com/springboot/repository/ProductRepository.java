package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	
}
