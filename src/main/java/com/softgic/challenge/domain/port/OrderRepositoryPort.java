package com.softgic.challenge.domain.port;

import com.softgic.challenge.domain.model.Order;
import reactor.core.publisher.Mono;

public interface OrderRepositoryPort {
    Mono<Order> save(Order order);
}
