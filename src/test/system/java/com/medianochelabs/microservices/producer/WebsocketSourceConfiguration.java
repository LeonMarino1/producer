package com.medianochelabs.microservices.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.medianochelabs.microservices.producer.adapter.in.web.controller.CreateProductController;
import com.medianochelabs.microservices.producer.adapter.in.web.controller.GetProductCatalogController;
import com.medianochelabs.microservices.producer.application.port.in.CreateProductUserCasePort;
import com.medianochelabs.microservices.producer.application.usecase.CreateProductUseCase;

@Configuration
public class WebsocketSourceConfiguration {
	
	
	
	@Autowired
	CreateProductController createProductControllerBean;
	
	@Autowired
	GetProductCatalogController getProductCatalogControllerBean;
	
	@Autowired
	CreateProductUseCase createProductUseCase;
	
	@Bean
	ServletWebServerFactory servletWebServerFactory() {
		return new TomcatServletWebServerFactory();
	}
	
	@Bean
	CreateProductUserCasePort createProductUseCasePort() {
		return createProductUseCase;
	}
	
	/*
	 * @Bean CreateProductController createProductController() { return
	 * createProductControllerBean; }
	 * 
	 * @Bean GetProductCatalogController getProductCatalogController() { return
	 * getProductCatalogControllerBean; }
	 */
	
}
