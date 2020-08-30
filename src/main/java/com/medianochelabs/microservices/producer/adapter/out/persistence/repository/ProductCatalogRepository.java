package com.medianochelabs.microservices.producer.adapter.out.persistence.repository;

import com.medianochelabs.microservices.producer.adapter.out.persistence.repository.model.ProductEntity;
import java.util.List;

public interface ProductCatalogRepository {
    List<ProductEntity> findProducts();
    boolean save(ProductEntity product);
}
