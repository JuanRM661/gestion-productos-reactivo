package com.example.productos.service;

import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    public Flux<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por su ID
    public Mono<Producto> obtenerPorId(String id) {
        return productoRepository.findById(id);
    }

    // Guardar un nuevo producto
    public Mono<Producto> guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar un producto por su ID
    public Mono<Void> eliminarProducto(String id) {
        return productoRepository.deleteById(id);
    }
}


