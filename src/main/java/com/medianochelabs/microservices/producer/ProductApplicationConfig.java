package com.medianochelabs.microservices.producer;

import com.medianochelabs.microservices.producer.application.port.in.CreateProductUserCasePort;
import com.medianochelabs.microservices.producer.application.usecase.CreateProductUseCase;
import com.medianochelabs.microservices.producer.adapter.out.persistence.ProductCatalogPersistenceAdapter;
import com.medianochelabs.microservices.producer.application.port.in.GetCatalogQueryPort;
import com.medianochelabs.microservices.producer.application.usecase.GetCatalogQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductApplicationConfig {

    @Bean
    public GetCatalogQueryPort showCatalogUseCase(ProductCatalogPersistenceAdapter adapter) {
        return new GetCatalogQuery(adapter);
    }

    @Bean
    public CreateProductUserCasePort createProductUserCase(ProductCatalogPersistenceAdapter adapter) {
        return new CreateProductUseCase(adapter);
    }

}
