package com.medianochelabs.microservices.producer.adapter.in.web.controller;

import com.medianochelabs.microservices.producer.application.port.in.CreateProductUserCasePort;
import com.medianochelabs.microservices.producer.adapter.in.web.dto.CreateProductPayload;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
public class CreateProductController {
	
    private CreateProductUserCasePort createProductUseCase;

    @PostMapping(path = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> postNewProduct(@RequestBody CreateProductPayload product) {
        var createNewProductCmd =
                new CreateProductUserCasePort.CreateNewProductCommand(product.getName(), product.getPrice());

        createProductUseCase.createNewProduct(createNewProductCmd);

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri())
                .build();
    }
}
