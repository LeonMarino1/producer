package com.medianochelabs.microservices.producer.application.usecase;

import com.medianochelabs.microservices.producer.application.port.out.LoadProductsPort;
import com.medianochelabs.microservices.producer.application.port.in.GetCatalogQueryPort;
import com.medianochelabs.microservices.producer.domain.exception.ProductNotFound;
import com.medianochelabs.microservices.producer.domain.model.Product;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class GetCatalogQuery implements GetCatalogQueryPort {
    private LoadProductsPort loadProductsPort;

    @Override
    public List<Product> getAllProducts() {
        return loadProductsPort.loadProducts();
    }

    @Override
    public Product getProduct(String productName) {
        var product = loadProductsPort
                        .loadProducts()
                        .stream()
                        .filter(p -> p.getName().equalsIgnoreCase(productName))
                        .findFirst().orElseThrow(ProductNotFound::new);
        return product;
    }
}
