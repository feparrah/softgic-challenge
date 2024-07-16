package com.softgic.challenge.infraestructure.repository;

import com.softgic.challenge.infraestructure.entity.OrderEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ReactiveOrderRepository extends R2dbcRepository<OrderEntity, Long> {
}
