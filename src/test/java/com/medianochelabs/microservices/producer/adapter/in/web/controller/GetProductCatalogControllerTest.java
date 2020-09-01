package com.medianochelabs.microservices.producer.adapter.in.web.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medianochelabs.microservices.producer.adapter.in.web.dto.CreateProductPayload;
import com.medianochelabs.microservices.producer.adapter.in.web.dto.ProductResource;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class GetProductCatalogControllerTest {
    
	@LocalServerPort
	private int port;
	
TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	private CreateProductPayload payload;
	private String url="/products";
	private HttpEntity<Void> entity = null;
	private String producto = "HTC";
	
	
	@Before
	void setUp() {
		payload = new CreateProductPayload();
		payload.setPrice(200.0d);
		payload.setName("Super led bulb");
		entity = new HttpEntity<Void>(null,headers);
		
	}
	
	@Test
	void getAllProductsTest() {
		
		ResponseEntity<List> response = restTemplate.exchange(createURLWithPort(url), HttpMethod.GET, entity, List.class);
		
		assertNotNull(response);
		
	}
	
	@Test
	void getProductTest() {
		ResponseEntity<ProductResource> response = restTemplate.exchange(createURLWithPort(url+"/"+producto), HttpMethod.GET, entity, ProductResource.class);
		
		assertNotNull(response);
		
		producto = "Pixel 45";
		
        response = restTemplate.exchange(createURLWithPort(url+"/"+producto), HttpMethod.GET, entity, ProductResource.class);
		
		ProductResource resource = response.getBody();
		
		assertNull(resource,"We were expecting a null resource instead got: "+resource);
		
		
	}
	
	
	private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
