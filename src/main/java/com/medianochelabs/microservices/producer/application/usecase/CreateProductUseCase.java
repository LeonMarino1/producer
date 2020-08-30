package com.medianochelabs.microservices.producer.application.usecase;

import com.medianochelabs.microservices.producer.application.port.in.CreateProductUserCasePort;
import com.medianochelabs.microservices.producer.application.port.out.SaveProductPort;
import com.medianochelabs.microservices.producer.domain.model.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProductUseCase implements CreateProductUserCasePort {
    private SaveProductPort saveProductPort;

    @Override
    public boolean createNewProduct(CreateNewProductCommand cmd) {
        // Validates Business Rules
        var product = new Product(cmd.getName(), cmd.getPrice());
        return saveProductPort.save(product);
    }
}
