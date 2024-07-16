package com.softgic.challenge.infraestructure.repository;

import com.softgic.challenge.domain.model.Order;
import com.softgic.challenge.domain.port.OrderRepositoryPort;
import com.softgic.challenge.infraestructure.entity.OrderEntity;
import com.softgic.challenge.infraestructure.entity.ProductEntity;
import com.softgic.challenge.infraestructure.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReactiveOrderRepositoryAdapter implements OrderRepositoryPort {
    
    private final ReactiveOrderRepository reactiveOrderRepository;
    
    private final ReactiveProductRepository reactiveProductRepository;

    public ReactiveOrderRepositoryAdapter(ReactiveOrderRepository reactiveOrderRepository, ReactiveProductRepository reactiveProductRepository) {
        this.reactiveOrderRepository = reactiveOrderRepository;
        this.reactiveProductRepository = reactiveProductRepository;
    }

    @Override
    public Mono<Order> save(Order order) {
        List<ProductEntity> productEntityList = new ArrayList<>();
        order.getProducts().stream().forEach(o -> 
                reactiveProductRepository.findById(o.getId())
                        .subscribe(productEntityList::add)
        );
        Mono<OrderEntity> entity = reactiveOrderRepository.save(OrderMapper.toEntity(order, productEntityList));
        return entity.map(OrderMapper::toDomainModel);
    }
}
