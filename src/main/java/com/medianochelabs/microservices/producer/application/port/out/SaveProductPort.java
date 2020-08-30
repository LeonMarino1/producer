package com.medianochelabs.microservices.producer.application.port.out;

import com.medianochelabs.microservices.producer.domain.model.Product;

public interface SaveProductPort {
    boolean save(Product product);

}
