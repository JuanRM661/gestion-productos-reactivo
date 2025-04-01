package com.example.productos.service;

import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    public void listarProductos() {
        // Datos de prueba
        Producto producto1 = new Producto();
        producto1.setId("1");
        producto1.setNombre("Producto 1");
        producto1.setPrecio(100);

        Producto producto2 = new Producto();
        producto2.setId("2");
        producto2.setNombre("Producto 2");
        producto2.setPrecio(200);

        // Simulamos el comportamiento del repositorio
        when(productoRepository.findAll()).thenReturn(Flux.just(producto1, producto2));

        // Llamamos al método y verificamos el resultado
        Flux<Producto> productos = productoService.obtenerTodos();
        assertEquals(2, productos.collectList().block().size());
    }

    @Test
    public void obtenerProductoPorId() {
        Producto producto = new Producto();
        producto.setId("1");
        producto.setNombre("Producto 1");
        producto.setPrecio(100);

        // Simulamos el comportamiento del repositorio
        when(productoRepository.findById("1")).thenReturn(Mono.just(producto));

        // Llamamos al método y verificamos el resultado
        Mono<Producto> productoMono = productoService.obtenerPorId("1");
        assertEquals("Producto 1", productoMono.block().getNombre());
    }

    @Test
    public void crearProducto() {
        Producto producto = new Producto();
        producto.setNombre("Producto 1");
        producto.setPrecio(100);

        // Simulamos el comportamiento del repositorio
        when(productoRepository.save(producto)).thenReturn(Mono.just(producto));

        // Llamamos al método y verificamos el resultado
        Mono<Producto> productoMono = productoService.guardarProducto(producto);
        assertEquals("Producto 1", productoMono.block().getNombre());
    }
}
