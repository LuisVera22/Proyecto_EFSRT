package com.proyecto.service;

import java.util.List;

import com.proyecto.model.AutorEntity;

public interface AutorService {
    List<AutorEntity>listadoAutores();
    void registrarAutor(AutorEntity nuevoAutor);
    AutorEntity buscarAutorPorId(Integer id);
    void actualizarAutor(Integer id, AutorEntity autorActualizado);
    void eliminarAutor(Integer id);
}
