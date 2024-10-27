package com.proyecto.service;

import java.util.List;

import com.proyecto.model.EditorialEntity;

public interface EditorialService {
    List<EditorialEntity> listadoEditoriales();
    void reistrarEditorial(EditorialEntity nuevaEditorial);
    EditorialEntity buscarEditorialPorId(Integer id);
    void actualizarEditorial(Integer id, EditorialEntity editorialActualizada);
    void eliminarEditorial(Integer id);
}
