package com.medianochelabs.microservices.producer.adapter.in.web.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.swing.text.html.parser.Entity;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medianochelabs.microservices.producer.adapter.in.web.dto.CreateProductPayload;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CreateProductControllerTest {
	
	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	private CreateProductPayload payload;
	private String url="/products";
	private HttpEntity<String> entity = null;
	private String jsonString = null;
	
	@Before
	void setUp() {
		payload = new CreateProductPayload();
		payload.setPrice(200.0d);
		payload.setName("Super led bulb");
		jsonString = "{\"name\":"+payload.getName()+",\"price\":"+payload.getPrice()+"}";
		entity = new HttpEntity<>(jsonString,headers);
		
	}
	
	@Test
	void testProducts() {
		
		payload = new CreateProductPayload();
		payload.setPrice(200.0d);
		payload.setName("Cubrebocas");
		//jsonString = "{\"name\":"+payload.getName()+",\"price\":"+payload.getPrice()+"}";
		jsonString ="{\n" + 
				"	\"name\": \"Cubrebocas\",\n" + 
				"	\"price\": 200.00\n" + 
				"}";
		headers.add("Content-Type", "application/json");
		entity = new HttpEntity<>(jsonString,headers);
		
		
		ResponseEntity<Void> response = restTemplate.exchange(createURLWithPort(url), HttpMethod.POST, entity, Void.class);
		
		assertNotNull(response);
	}
	
	private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
	
}
