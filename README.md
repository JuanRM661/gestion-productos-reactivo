# Explicación del Trabajo - Parcial 1B: Gestión de Productos Reactivo

## Introducción

Este proyecto corresponde al **Parcial 1B** de la asignatura Lenguaje de Programación Avanzado 2. El objetivo principal es desarrollar una aplicación que gestione productos de forma reactiva utilizando **Spring WebFlux** y **Spring Boot**. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos mediante una API RESTful.

## Objetivos del Proyecto

1. Desarrollar una aplicación web utilizando Spring WebFlux para ofrecer una solución reactiva para la gestión de productos.
2. Implementar operaciones CRUD para productos: creación, lectura, actualización y eliminación.
3. Realizar pruebas unitarias para asegurar que las funcionalidades estén correctamente implementadas.
4. Usar **Maven** para gestionar dependencias y construir el proyecto.

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para la construcción de la aplicación.
- **Spring WebFlux**: Para la implementación de una arquitectura reactiva que permite la ejecución no bloqueante de las operaciones.
- **JUnit 5**: Herramienta para implementar pruebas unitarias y asegurar la calidad del código.
- **Maven**: Sistema de gestión de dependencias y construcción de proyectos.

## Diseño de la Solución

### 1. Arquitectura Reactiva con WebFlux

La aplicación utiliza **Spring WebFlux**, un marco reactivo, que permite manejar múltiples solicitudes concurrentes de manera eficiente sin bloquear los hilos principales. Este enfoque es ideal para aplicaciones que requieren escalabilidad y eficiencia en la gestión de recursos.

### 2. Operaciones CRUD de Productos

La aplicación permite a los usuarios realizar las siguientes operaciones sobre los productos:

- **Crear**: Registrar un nuevo producto con su nombre y precio.
- **Leer**: Consultar todos los productos registrados o un producto específico por su ID.
- **Actualizar**: Modificar la información de un producto existente.
- **Eliminar**: Eliminar un producto específico.

### 3. Exposición de la API

La API expone los siguientes endpoints:

- **POST /productos**: Crea un nuevo producto.
- **GET /productos**: Devuelve todos los productos.
- **GET /productos/{id}**: Devuelve un producto específico por su ID.
- **PUT /productos/{id}**: Actualiza los datos de un producto.
- **DELETE /productos/{id}**: Elimina un producto de la base de datos.

### 4. Persistencia de Datos

Para simplificar la implementación y la prueba del proyecto, se utiliza una lista en memoria para simular la persistencia de datos. Sin embargo, esta estructura es fácilmente reemplazable por una base de datos real (como MongoDB o PostgreSQL) en una versión futura del proyecto.

## Implementación

### 1. Controladores

Los controladores de la aplicación gestionan las solicitudes HTTP y están basados en la arquitectura reactiva de **Spring WebFlux**. Cada operación CRUD se maneja mediante métodos que devuelven tipos reactivos como `Mono` (para respuestas con 0 o 1 elemento) y `Flux` (para respuestas con 0 o N elementos).

### 2. Servicios

Los servicios contienen la lógica de negocio. La implementación actual usa una estructura de datos en memoria (un `Map`) para almacenar los productos, y los métodos en los servicios realizan las operaciones necesarias sobre esta estructura, como agregar, actualizar o eliminar productos.

### 3. Pruebas Unitarias

Se han implementado pruebas unitarias utilizando **JUnit 5** para garantizar que las funcionalidades del sistema operen correctamente. Estas pruebas verifican que las operaciones CRUD (creación, obtención, actualización y eliminación de productos) funcionen como se espera.

## Conclusiones

Este proyecto permite gestionar productos utilizando una aplicación reactiva desarrollada con **Spring WebFlux**. La solución es escalable, eficiente y puede manejar múltiples solicitudes concurrentes sin bloquear los hilos del servidor.

Aunque en esta versión se ha usado una lista en memoria como persistencia de datos, el sistema está diseñado para integrarse fácilmente con bases de datos reales mediante **Spring Data** en el futuro.


