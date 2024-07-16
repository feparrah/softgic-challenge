package com.softgic.challenge.application.usecase;

import com.softgic.challenge.domain.model.Order;
import com.softgic.challenge.domain.model.request.OrderRequest;
import reactor.core.publisher.Mono;

public interface CreateOrderUseCase {
    Mono<Order> placeOrder(OrderRequest orderRequest);
}
