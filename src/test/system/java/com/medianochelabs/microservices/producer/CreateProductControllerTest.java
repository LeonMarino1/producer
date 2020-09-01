package com.medianochelabs.microservices.producer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;

import com.medianochelabs.microservices.producer.adapter.in.web.controller.CreateProductController;
import com.medianochelabs.microservices.producer.adapter.in.web.dto.CreateProductPayload;
import com.medianochelabs.microservices.producer.application.port.in.CreateProductUserCasePort;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes= {CreateProductControllerTest.class, WebsocketSourceConfiguration.class, 
		CreateProductController.class, CreateProductUserCasePort.class},
properties= {"local.server.port=80080","server.port=9090"})

@RunWith(SpringRunner.class)
public class CreateProductControllerTest {
	
	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	private CreateProductPayload payload;
	private String url="/products";
	private HttpEntity<CreateProductPayload> entity = null;
	
	@Before
	public void setup() {
		payload = new CreateProductPayload();
		payload.setPrice(200.0d);
		payload.setName("Super led bulb");
		entity = new HttpEntity<CreateProductPayload>(payload,headers);
		
	}
	
	@Ignore
	@Test
	public void testProducts() { 
		
		//ResponseEntity<Void> response = restTemplate.getForObject(createURLWithPort(url), ResponseEntity.class);
		
		ResponseEntity<Void> response = restTemplate.exchange(createURLWithPort(url), HttpMethod.POST, entity, Void.class);
		
		assertNotNull(response);
	}
	
	private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
