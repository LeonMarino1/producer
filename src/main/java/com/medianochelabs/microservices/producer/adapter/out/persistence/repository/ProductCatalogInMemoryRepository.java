package com.medianochelabs.microservices.producer.adapter.out.persistence.repository;

import com.medianochelabs.microservices.producer.adapter.out.persistence.repository.model.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductCatalogInMemoryRepository  implements ProductCatalogRepository{
    private final List<ProductEntity> products = new ArrayList<>();
    {
        products.add(new ProductEntity("iPhone 6,1999.9"));
        products.add(new ProductEntity("Huawei P30,2899.9"));
        products.add(new ProductEntity("HTC,1799.9"));
        products.add(new ProductEntity("iPhone X,1599.9"));
        products.add(new ProductEntity("Samsung A80 6,449.9"));
        products.add(new ProductEntity("Nokia AX,349.9"));
        products.add(new ProductEntity("Sony Xperia,859.9"));
        products.add(new ProductEntity("iPhone 11,3329.9"));
        products.add(new ProductEntity("OnePlus Pro,2789.9"));
        products.add(new ProductEntity("Pixel 4 XL,899.9"));
        products.add(new ProductEntity("LG V60 ThinQ,1669.9"));
        products.add(new ProductEntity("Xiaomi T3,299.9"));
        products.add(new ProductEntity("iPhone SE,829.9"));
        products.add(new ProductEntity("Motorola Play G,99.9"));
    }

    @Override
    public List<ProductEntity> findProducts() {
        return products;
    }

    @Override
    public boolean save(ProductEntity product) {
        this.products.add(product);
        return true;
    }
}
