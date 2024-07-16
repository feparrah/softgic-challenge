package com.softgic.challenge.application.service;

import com.softgic.challenge.domain.model.Product;
import com.softgic.challenge.application.usecase.GetProductUseCase;
import com.softgic.challenge.domain.port.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements GetProductUseCase {
    
    private final ProductRepositoryPort productRepositoryPort;

    @Autowired
    public ProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }


    @Override
    public Mono<Product> getProductById(Long id) {
        return productRepositoryPort.findById(id);
    }
}
