package com.softgic.challenge.domain.port;

import com.softgic.challenge.domain.model.Product;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface ProductRepositoryPort {
    Mono<Product> findById(Long id);
    Mono<Product> save(Product product);
}
