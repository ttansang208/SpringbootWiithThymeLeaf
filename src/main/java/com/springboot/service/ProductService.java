package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.ProductEntity;
import com.springboot.exception.ProductNotFoundException;
import com.springboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<ProductEntity> findAll() {
		return productRepository.findAll();
	}

	public void save(ProductEntity product) {
		productRepository.save(product);
	}

	public ProductEntity getById(Integer id) throws ProductNotFoundException {
		Optional<ProductEntity> result = productRepository.findById(id);
		if (result.isPresent()) {
			return result.get();	
		} else {
			throw new ProductNotFoundException("Could not found any product with id " + id);
		}
	}
	
	public void deleteById(Integer id){		
		productRepository.deleteById(id);
	}
}
