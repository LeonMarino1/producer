package com.medianochelabs.microservices.producer.adapter.in.web.controller;

import com.medianochelabs.microservices.producer.application.port.in.GetCatalogQueryPort;
import com.medianochelabs.microservices.producer.adapter.in.web.dto.ProductResource;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
public class GetProductCatalogController {
    private GetCatalogQueryPort productCatalogQuery;

    @GetMapping(path = "/products", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductResource>> getProductCatalog() {
        var result = productCatalogQuery
                .getAllProducts()
                .stream()
                .map(p -> new ProductResource(p.getName(), p.getPrice()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "/products/{name}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResource> getProduct(@PathVariable String name) {
        var product = productCatalogQuery.getProduct(name);
        return ResponseEntity.ok(new ProductResource(product.getName(), product.getPrice()));
    }
}
