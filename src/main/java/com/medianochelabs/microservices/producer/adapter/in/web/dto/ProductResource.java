package com.medianochelabs.microservices.producer.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class ProductResource {
    private String productName;
    private Double productPrice;
}
