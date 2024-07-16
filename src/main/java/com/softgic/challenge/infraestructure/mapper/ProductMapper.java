package com.softgic.challenge.infraestructure.mapper;

import com.softgic.challenge.domain.model.Product;
import com.softgic.challenge.infraestructure.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    
    public static Product toDomainModel(ProductEntity productEntity){
        return new Product(productEntity.getId(), productEntity.getName(), productEntity.getPrice(), productEntity.getQuantity());
    }
    
    public static List<Product> toDomainModelList(List<ProductEntity> productEntityList){
        return productEntityList.stream().map(ProductMapper::toDomainModel).collect(Collectors.toList());
    }
}
