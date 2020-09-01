package com.medianochelabs.microservices.producer.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
	
	
	@Test
	void productTest() {
		Product product = new Product("Pixel 3",400.0d);
		
		assertEquals(product.getName(),"Pixel 3");
		assertEquals(product.getPrice(), 400.0d);
		
		
		product.setName("Pixel 2");
		product.setPrice(200.0d);
		
		assertEquals(product.getName(),"Pixel 2");
		assertEquals(product.getPrice(), 200.0d);
		
		assertEquals(product.toString(),"Product(name=Pixel 2, price=200.0)");
		assertEquals(product.hashCode(),1901122241);
		
		Product other = new Product("Pixel 2", 200.0d);
		
		assertEquals(product, other);
		
	}
	

}
