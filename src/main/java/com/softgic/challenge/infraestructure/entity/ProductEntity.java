package com.softgic.challenge.infraestructure.entity;

import com.softgic.challenge.domain.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("product")
@AllArgsConstructor
@Getter
public class ProductEntity {
    
    @Id
    private Long id;
    private String name;
    private Double price;
    private Long quantity;
    
    public static ProductEntity fromDomainModel(Product product){
        return new ProductEntity(product.getId(), product.getName(), product.getPrice(), product.getQuantity());
    }
}
