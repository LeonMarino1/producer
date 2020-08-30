package com.medianochelabs.microservices.producer.application.port.in;

import com.medianochelabs.microservices.producer.domain.model.Product;
import java.util.List;

public interface GetCatalogQueryPort {
    List<Product> getAllProducts();
    Product getProduct(String productName);
}
