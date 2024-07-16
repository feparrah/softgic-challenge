package com.softgic.challenge.domain.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Double price;
    private Long quantity;
}
