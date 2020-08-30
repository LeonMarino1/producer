package com.medianochelabs.microservices.producer.adapter.out.persistence;

import com.medianochelabs.microservices.producer.adapter.out.persistence.mapper.ProductMapper;
import com.medianochelabs.microservices.producer.application.port.out.SaveProductPort;
import com.medianochelabs.microservices.producer.adapter.out.persistence.repository.ProductCatalogRepository;
import com.medianochelabs.microservices.producer.adapter.out.persistence.repository.model.ProductEntity;
import com.medianochelabs.microservices.producer.application.port.out.LoadProductsPort;
import com.medianochelabs.microservices.producer.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductCatalogPersistenceAdapter implements LoadProductsPort, SaveProductPort {
    private ProductCatalogRepository productCatalogRepository;
    private ProductMapper productMapper;

    @Override
    public List<Product> loadProducts() {
        List<ProductEntity> productEntities = productCatalogRepository.findProducts();
        return productEntities
                    .stream()
                    .map(productMapper::mapToDomainModel)
                    .collect(Collectors.toList());
    }

    @Override
    public boolean save(Product product) {
        var productEntity = productMapper.mapToEntity(product);
        return productCatalogRepository.save(productEntity);
    }
}
