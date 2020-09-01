package com.medianochelabs.microservices.producer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.medianochelabs.microservices.producer.adapter.in.web.controller.GetProductCatalogController;
import com.medianochelabs.microservices.producer.adapter.in.web.dto.CreateProductPayload;
import com.medianochelabs.microservices.producer.adapter.in.web.dto.ProductResource;


@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes= {GetProductCatalogControllerTest.class, GetProductCatalogController.class,
		WebsocketSourceConfiguration.class}, properties= {"local.server.port=8080", "server.port=9090"})
@RunWith(SpringRunner.class)
public class GetProductCatalogControllerTest {
    
	@LocalServerPort
	private int port;
	
TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	private CreateProductPayload payload;
	private String url="/products";
	private HttpEntity<Void> entity = null;
	private String producto = "Cubrebocas";
	
	@Before
	public void setup() {
		payload = new CreateProductPayload();
		payload.setPrice(200.0d);
		payload.setName("Super led bulb");
		entity = new HttpEntity<Void>(null,headers);
		
	}
	
	@Ignore
	@Test
	public void getAllProductsTest() {
		
		//ResponseEntity<List> response = restTemplate.getForObject(createURLWithPort(url), ResponseEntity.class);
		ResponseEntity<List> response = restTemplate.exchange(createURLWithPort(url), HttpMethod.GET, entity, List.class);
		
		assertNotNull(response);
		
	}
	
	@Ignore
	@Test
	public void getProductTest() {
		
		//ResponseEntity<Void> response = restTemplate.getForObject(createURLWithPort(url), ResponseEntity.class);
		ResponseEntity<ProductResource> response = restTemplate.exchange(createURLWithPort(url+"/"+producto), HttpMethod.GET, entity, ProductResource.class);
		
		assertNotNull(response);
	}
	
	
	private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
