package com.softgic.challenge.infraestructure.repository;

import com.softgic.challenge.infraestructure.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveProductRepository extends R2dbcRepository<ProductEntity, Long> {
}
