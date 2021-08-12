package com.springboot;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.springboot.entity.ProductEntity;
import com.springboot.repository.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testAddnew(){
		ProductEntity product = new ProductEntity();
		product.setName("Laptop ASUS TUF Gaming F15");
		product.setType("Laptop");
		product.setProducer("Asus");
		product.setPrice(17000000);
		product.setDescription("Bền bỉ đạt tiêu chuẩn quân đội");		
		ProductEntity saveProduct = productRepository.save(product);		
		Assertions.assertThat(saveProduct).isNotNull();
		Assertions.assertThat(saveProduct.getId()).isGreaterThan(0);
	}	
	
	@Test
	public void testListAll() {
		Iterable<ProductEntity> prodList = productRepository.findAll();
		Assertions.assertThat(prodList).hasSizeGreaterThan(0);
		for(ProductEntity products : prodList) {
			System.out.println(products);
		}
		
	}
	
	@Test
	public void testUpdate() {
		Integer productId = 1;
		Optional<ProductEntity> optionalProd =  productRepository.findById(productId);
		ProductEntity prod = optionalProd.get();
		prod.setName("DELL");
		ProductEntity updateProd = productRepository.findById(productId).get();
		Assertions.assertThat(updateProd.getName()).isEqualTo("DELL");
	}
}
