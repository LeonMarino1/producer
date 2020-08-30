package com.medianochelabs.microservices.producer.application.port.out;

import com.medianochelabs.microservices.producer.domain.model.Product;

import java.util.List;

public interface LoadProductsPort {
    List<Product> loadProducts();
}
