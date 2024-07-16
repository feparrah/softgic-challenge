package com.softgic.challenge.domain.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderRequest {
    @NotNull(message = "Description cannot be null")
    private String description;
    @NotNull
    private List<OrderProduct> products;
    @NotNull(message = "User Id cannot be nul")
    private Long userId;
}