package com.softgic.challenge.application.usecase;

import com.softgic.challenge.domain.model.Product;
import reactor.core.publisher.Mono;

public interface GetProductUseCase {
    Mono<Product> getProductById(Long id);
}
