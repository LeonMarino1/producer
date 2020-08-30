package com.medianochelabs.microservices.producer.adapter.out.persistence.mapper;

import com.medianochelabs.microservices.producer.adapter.out.persistence.repository.model.ProductEntity;
import com.medianochelabs.microservices.producer.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product mapToDomainModel(ProductEntity productEntity) {
        var productRow = productEntity.getProductLine().split(",");
        return new Product(productRow[0], Double.valueOf(productRow[1]));
    }

    public ProductEntity mapToEntity(Product product) {
        String entry = String.join(",", product.getName(), product.getPrice().toString());
        return new ProductEntity(entry);
    }
}
