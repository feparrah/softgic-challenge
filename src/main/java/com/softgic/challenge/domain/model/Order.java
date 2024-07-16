package com.softgic.challenge.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private List<Product> products;
    private Double total;
}
