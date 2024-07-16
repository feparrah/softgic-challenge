package com.softgic.challenge.infraestructure.controller;

import com.softgic.challenge.application.service.ProductService;
import com.softgic.challenge.domain.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Product> getById(@PathVariable Long id){
        return productService.getProductById(id);
    }
}
