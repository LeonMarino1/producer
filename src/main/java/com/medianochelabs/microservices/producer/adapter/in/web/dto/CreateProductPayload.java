package com.medianochelabs.microservices.producer.adapter.in.web.dto;

import lombok.Data;

@Data
public class CreateProductPayload {
    private String name;
    private Double price;
}
