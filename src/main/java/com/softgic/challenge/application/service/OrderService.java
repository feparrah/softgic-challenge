package com.softgic.challenge.application.service;

import com.softgic.challenge.application.usecase.CreateOrderUseCase;
import com.softgic.challenge.domain.model.Order;
import com.softgic.challenge.domain.model.Product;
import com.softgic.challenge.domain.model.request.OrderRequest;
import com.softgic.challenge.domain.port.OrderRepositoryPort;
import com.softgic.challenge.domain.port.ProductRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class OrderService implements CreateOrderUseCase {
    
    private final OrderRepositoryPort orderRepositoryPort;
    
    private final ProductRepositoryPort productRepositoryPort;

    public OrderService(OrderRepositoryPort orderRepositoryPort, ProductRepositoryPort productRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Mono<Order> placeOrder(OrderRequest orderRequest) {
        List<Product> productList = new ArrayList<>();
        AtomicReference<Double> total = new AtomicReference<>(0.0);
                orderRequest.getProducts().stream().forEach(it ->
                productRepositoryPort.findById(it.getId())
                        .switchIfEmpty(
                                Mono.error(new IllegalArgumentException("Product id not found: "+it.getId())))
                        .flatMap( product -> {
                            if(it.getQuantity() <=0 ){
                                return Mono.error(new IllegalArgumentException("Product without stock: "+product.getName()));
                            }
                            total.updateAndGet(v -> v + product.getPrice() * it.getQuantity());
                            return Mono.just(product);
                        }).subscribe(productList::add)
        );
        return orderRepositoryPort.save(
                new Order(null, orderRequest.getUserId(), 
                        productList, total.get()));
    }
}
