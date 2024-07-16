package com.softgic.challenge.infraestructure.repository;

import com.softgic.challenge.domain.model.Product;
import com.softgic.challenge.domain.port.ProductRepositoryPort;
import com.softgic.challenge.infraestructure.entity.ProductEntity;
import com.softgic.challenge.infraestructure.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ReactiveProductRepositoryAdapter implements ProductRepositoryPort {
    
    private final ReactiveProductRepository reactiveProductRepository;

    public ReactiveProductRepositoryAdapter(ReactiveProductRepository reactiveProductRepository) {
        this.reactiveProductRepository = reactiveProductRepository;
    }

    @Override
    public Mono<Product> findById(Long id) {
        return reactiveProductRepository.findById(id).map(ProductMapper::toDomainModel);
    }

    @Override
    public Mono<Product> save(Product product) {
        Mono<ProductEntity> entity = reactiveProductRepository.save(ProductEntity.fromDomainModel(product));
        return entity.map(ProductMapper::toDomainModel);
    }
}
