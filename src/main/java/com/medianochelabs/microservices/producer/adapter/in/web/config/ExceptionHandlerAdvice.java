package com.medianochelabs.microservices.producer.adapter.in.web.config;

import com.medianochelabs.microservices.producer.domain.exception.ProductNotFound;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.core.Ordered;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = ProductNotFound.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFound e) {
        return ResponseEntity.notFound().build();
    }
}
