package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.Inventario;
import com.proyecto.model.LibroEntity;

public interface LibroService {
    List<LibroEntity>listadoLibros();
    void registrarLibro(LibroEntity nuevoLibro, MultipartFile imagen);
    Optional<LibroEntity> buscarLibroPorId(String isbn);
    void actualizarLibro(String isbn, LibroEntity libroActualizado, MultipartFile imagen);
    void eliminarLibro(String isbn);
   
    List<Inventario> listaInventario();

}
