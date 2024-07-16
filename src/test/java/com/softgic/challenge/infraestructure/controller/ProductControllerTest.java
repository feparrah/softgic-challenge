package com.softgic.challenge.infraestructure.controller;

import com.softgic.challenge.application.service.ProductService;
import com.softgic.challenge.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class ProductControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private DatabaseClient databaseClient;

    @Mock
    private ProductService productService;

    private Mono<Product> getData() {
        return Mono.just(new Product(1L, "test1", 10.00, 1L));
    }

    @Test
    public void test_get_product() {
        Mockito.when(productService.getProductById(ArgumentMatchers.anyLong())).thenReturn(getData());
        webTestClient.get().uri("/product/1").exchange().expectStatus().isOk().expectBody().jsonPath("$.id", "1");
    }

}
