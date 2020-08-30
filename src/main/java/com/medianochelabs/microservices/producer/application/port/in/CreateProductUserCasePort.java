package com.medianochelabs.microservices.producer.application.port.in;

import lombok.Getter;
import lombok.NonNull;

public interface CreateProductUserCasePort {

    boolean createNewProduct(CreateNewProductCommand createNewProductCommand);

    @Getter
    class CreateNewProductCommand {
        private String name;
        private Double price;

        //validates inputs
        public CreateNewProductCommand(
            @NonNull String name,
            @NonNull Double price
        ) {
           this.name = name;
           this.price = price;
        }
    }
}
