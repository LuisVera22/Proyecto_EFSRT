package com.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.CategoriaEntity;
import com.proyecto.repository.CategoriaRepository;
import com.proyecto.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaSrviceImpl implements CategoriaService {
   @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public List<CategoriaEntity> listadoCategorias() {
        
        return categoriaRepository.findAll();
    }

    @Override
    public void registrarCategoria(CategoriaEntity categoriaNueva) {
        // TODO Auto-generated method stub
        categoriaRepository.save(categoriaNueva);
    }

    @Override
    public CategoriaEntity buscarCategoriaPorId(Integer id) {
        // TODO Auto-generated method stub
        return categoriaRepository.findById(id).get();
    }

    @Override
    public void actualizarCategoria(Integer id, CategoriaEntity categoriaActualizada) {
        // TODO Auto-generated method stub
        CategoriaEntity categoriaEncontrada = buscarCategoriaPorId(id);

        if(categoriaEncontrada==null){
            throw new RuntimeException("Categoria no encontrada");
        } try {
            categoriaEncontrada.setLibros(categoriaActualizada.getLibros());
            categoriaEncontrada.setNombreCategoria(categoriaActualizada.getNombreCategoria());
            categoriaRepository.save(categoriaEncontrada);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Error al actualizar");
        }
    }

    @Override
    public void eliminarCategoria(Integer id) {
        // TODO Auto-generated method stub
        CategoriaEntity categoriaEncontrada = buscarCategoriaPorId(id);
        if (categoriaEncontrada==null) {
            throw new RuntimeException("Categoria no encontrada");
        }
        categoriaRepository.delete(categoriaEncontrada);
    }
    
}
