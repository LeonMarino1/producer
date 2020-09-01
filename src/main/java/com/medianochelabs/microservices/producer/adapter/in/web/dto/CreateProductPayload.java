package com.medianochelabs.microservices.producer.adapter.in.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CreateProductPayload {
	@JsonProperty("name")
    private String name;
	@JsonProperty("price")
    private Double price;
}
