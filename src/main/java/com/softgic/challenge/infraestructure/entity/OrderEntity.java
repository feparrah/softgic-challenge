package com.softgic.challenge.infraestructure.entity;

import com.softgic.challenge.domain.model.Order;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Table("order")
@AllArgsConstructor
@Getter
public class OrderEntity {
    @Id
    private Long id;
    private Long userId;
    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> products = new ArrayList<>();
    private Double total;
    
}
