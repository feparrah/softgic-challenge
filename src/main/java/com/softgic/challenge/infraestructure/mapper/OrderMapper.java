package com.softgic.challenge.infraestructure.mapper;

import com.softgic.challenge.domain.model.Order;
import com.softgic.challenge.infraestructure.entity.OrderEntity;
import com.softgic.challenge.infraestructure.entity.ProductEntity;

import java.util.List;

public class OrderMapper {
    
    public static Order toDomainModel(OrderEntity orderEntity){
        return new Order(
                orderEntity.getId(), orderEntity.getUserId(), ProductMapper.toDomainModelList(orderEntity.getProducts()), orderEntity.getTotal()
        );
    }
    
    public static OrderEntity toEntity(Order order, List<ProductEntity> productEntityList){
        return new OrderEntity(order.getId(), order.getUserId(), productEntityList, order.getTotal());
    }
}
