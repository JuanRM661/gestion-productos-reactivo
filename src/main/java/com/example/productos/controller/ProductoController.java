package com.example.productos.controller;

import com.example.productos.model.Producto;
import com.example.productos.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Obtener todos los productos
    @GetMapping
    public Flux<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public Mono<Producto> obtenerPorId(@PathVariable String id) {
        return productoService.obtenerPorId(id);
    }

    // Crear un nuevo producto
    @PostMapping
    public Mono<Producto> crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public Mono<Void> eliminarProducto(@PathVariable String id) {
        return productoService.eliminarProducto(id);
    }
}
