package com.medianochelabs.microservices.producer.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductResource {
    private String productName;
    private Double productPrice;
}
