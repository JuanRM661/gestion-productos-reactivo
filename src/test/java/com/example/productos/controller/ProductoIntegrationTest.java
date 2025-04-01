package com.example.productos.controller;

import com.example.productos.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductoIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    private Producto producto;

    @BeforeEach
    public void setup() {
        producto = new Producto();
        producto.setNombre("Producto Integración");
        producto.setPrecio(150.0);
    }

    @Test
    public void crearProducto() {
        webTestClient.post().uri("/productos")
            .bodyValue(producto)
            .exchange()
            .expectStatus().isCreated()
            .expectBody()
            .jsonPath("$.nombre").isEqualTo("Producto Integración")
            .jsonPath("$.precio").isEqualTo(150.0);
    }

    @Test
    public void obtenerProductoPorId() {
        webTestClient.get().uri("/productos/{id}", "1")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.nombre").isEqualTo("Producto 1");
    }

    @Test
    public void eliminarProducto() {
        webTestClient.delete().uri("/productos/{id}", "1")
            .exchange()
            .expectStatus().isNoContent();
    }
}
