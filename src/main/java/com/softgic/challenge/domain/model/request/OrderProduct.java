package com.softgic.challenge.domain.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderProduct {
    @NotNull(message = "Product id cannot be null")
    private Long id;
    @Size(min=1, message = "Product quantity must be greater than 0")
    private Long quantity;
}
