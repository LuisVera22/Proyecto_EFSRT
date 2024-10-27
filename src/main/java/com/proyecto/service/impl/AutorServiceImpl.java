package com.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.AutorEntity;
import com.proyecto.repository.AutorRepository;
import com.proyecto.service.AutorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService{
	@Autowired
    private AutorRepository autorRepository;

    @Override
    public List<AutorEntity> listadoAutores() {
        
        return autorRepository.findAll();
    }

    @Override
    public void registrarAutor(AutorEntity nuevoAutor) {
        // TODO Auto-generated method stub
        autorRepository.save(nuevoAutor);
    }

    @Override
    public AutorEntity buscarAutorPorId(Integer id) {
        // TODO Auto-generated method stub
        return autorRepository.findById(id).get();
    }

    @Override
    public void actualizarAutor(Integer id, AutorEntity autorActualizado) {
        // TODO Auto-generated method stub
        AutorEntity autorEncontrado = buscarAutorPorId(id);

        if(autorEncontrado==null){
            throw new RuntimeException("Autor no encontrado");
        }
        try{
            autorEncontrado.setNombreAutor(autorActualizado.getNombreAutor());
            autorEncontrado.setApellidoAutor(autorActualizado.getApellidoAutor());
            autorRepository.save(autorEncontrado);
        } catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al actualizar");
		}
    }

    @Override
    public void eliminarAutor(Integer id) {
        // TODO Auto-generated method stub
        AutorEntity autorEncontrado = buscarAutorPorId(id);
        if (autorEncontrado == null) {
            throw new RuntimeException("Autor no encontrado");
        }
        autorRepository.delete(autorEncontrado);
    }
    
}
