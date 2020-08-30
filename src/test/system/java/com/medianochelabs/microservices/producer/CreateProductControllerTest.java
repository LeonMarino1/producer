package com.medianochelabs.microservices.producer;

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
	private HttpEntity<CreateProductPayload> entity = null;
	
	@Before
	void setUp() {
		payload = new CreateProductPayload();
		payload.setPrice(200.0d);
		payload.setName("Super led bulb");
		entity = new HttpEntity<CreateProductPayload>(payload,headers);
		
	}
	
	@Test
	void testProducts() {
		
		ResponseEntity<Void> response = restTemplate.exchange(createURLWithPort(url), HttpMethod.POST, entity, Void.class);
		
		
		
		assertNotNull(response);
	}
	
	private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
