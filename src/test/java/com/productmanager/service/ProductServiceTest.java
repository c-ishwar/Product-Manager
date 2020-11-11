package com.productmanager.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.productmanager.entity.Product;
import com.productmanager.repository.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ProductServiceTest {
	
	
	@Autowired
	private ProductRepository repo;
	
	
	@Test
	public void testSaveProduct() {
		
		Product product = new Product("product name", "p.brand", "madein", 100.00f);
		product.setId(10l);
		repo.save(product);
		Optional<Product> product2 = repo.findById(10l);
		assertNotNull(product2);
		assertEquals(product2.get().getBrand(), "p.brand");
		
	}
	
	@Test
	public void testDeleteProduct() {
		
		Product product = new Product("product name", "p.brand", "madein", 100.00f);
		product.setId(10l);
		repo.save(product);
		repo.delete(product);
		
	}
	
	@Test
	public void testFindAllProduct() {
		
		Product product = new Product("product name", "p.brand", "madein", 100.00f);
		product.setId(10l);
		repo.save(product);
		List<Product> product2 = repo.findAll();
		assertNotNull(product2);
		
	}
	
	@Test
	public void testSearchProductByKey() {
		
		Product product = new Product("product name", "p.brand", "madein", 100.00f);
		product.setId(10l);
		repo.save(product);
		List<Product> product2 = repo.search("product");
		assertNotNull(product2);
		
	}

}
