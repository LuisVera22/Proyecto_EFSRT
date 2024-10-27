package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.model.LibroCategoriaEntity;
import com.proyecto.model.LibroCategoriaId;

public interface LibroCategoriaService {
    
    LibroCategoriaEntity guardarLibroCategoria(LibroCategoriaEntity libroCategoria);

    LibroCategoriaEntity actualizarLibroCategoria( LibroCategoriaId id , LibroCategoriaEntity libroCategoria);

    void eliminarLibroCategoria(LibroCategoriaId id);

    Optional<LibroCategoriaEntity> buscarLibroCategoriaPorId(LibroCategoriaId id);

    List<LibroCategoriaEntity> listarTodosCategoriaLibro();
}
