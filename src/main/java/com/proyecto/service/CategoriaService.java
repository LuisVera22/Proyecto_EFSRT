package com.proyecto.service;

import java.util.List;

import com.proyecto.model.CategoriaEntity;

public interface CategoriaService {
	
	
	
	List<CategoriaEntity> listadoCategorias();

	void registrarCategoria(CategoriaEntity categoriaNueva);

	CategoriaEntity buscarCategoriaPorId(Integer id);

	void actualizarCategoria(Integer id, CategoriaEntity categoriaActualizada);

	void eliminarCategoria(Integer id);
	

}
