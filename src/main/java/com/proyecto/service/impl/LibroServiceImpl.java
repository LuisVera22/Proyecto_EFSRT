package com.proyecto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.Inventario;
import com.proyecto.model.LibroEntity;
import com.proyecto.repository.EditorialRepository;
import com.proyecto.repository.LibroRepository;
import com.proyecto.service.LibroService;
import com.proyecto.utils.Utilitarios;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LibroServiceImpl implements LibroService{
	@Autowired
	private LibroRepository libroRepository;
    @Autowired
    private EditorialRepository editorialRepository;


    @Override
    public List<LibroEntity> listadoLibros() {
        return libroRepository.findAll();
    }

    @Override
    @Transactional
    public void registrarLibro(LibroEntity nuevoLibro, MultipartFile imagen) {
        try {
        	
            String nombreImagen = Utilitarios.guardarImagen(imagen);
            nuevoLibro.setUrlImagen(nombreImagen);
            libroRepository.save(nuevoLibro);
        } catch (Exception e) {
            throw new RuntimeException("Error al registrar el libro: " + e.getMessage());
        }
    }

    @Override
    public Optional<LibroEntity> buscarLibroPorId(String isbn) {
        return Optional.ofNullable(libroRepository.findByISBN(isbn));
    }

    @Override
    @Transactional
    public void actualizarLibro(String isbn, LibroEntity libroActualizado, MultipartFile imagen) {
        LibroEntity libroEncontrado = buscarLibroPorId(isbn)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        try {
            if (imagen != null && !imagen.isEmpty()) {
                String nombreImagen = Utilitarios.guardarImagen(imagen);
                libroActualizado.setUrlImagen(nombreImagen);
            }
            
            libroEncontrado.setAutorEntity(libroActualizado.getAutorEntity());
            libroEncontrado.setEditorialEntity(libroActualizado.getEditorialEntity());
            libroEncontrado.setFechapublicacion(libroActualizado.getFechapublicacion());
            libroEncontrado.setCategorias(libroActualizado.getCategorias());
            libroEncontrado.setPrecio(libroActualizado.getPrecio());
            libroEncontrado.setResenia(libroActualizado.getResenia());
            libroEncontrado.setRestriccionEdad(libroActualizado.getRestriccionEdad());
            libroEncontrado.setStock(libroActualizado.getStock());
            libroEncontrado.setTitulo(libroActualizado.getTitulo());
            libroRepository.save(libroEncontrado);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el libro: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminarLibro(String isbn) {
        LibroEntity libroEncontrado = buscarLibroPorId(isbn)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        try {
            libroRepository.delete(libroEncontrado);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el libro: " + e.getMessage());
        }
    }

	@Override
	public List<Inventario> listaInventario() {
		List<LibroEntity> libros = libroRepository.findAll();
        List<Inventario> inventarioList = new ArrayList<>();
        for (LibroEntity libro : libros) {
            String estado = libro.getStock() > 0 ? "En Stock" : "Fuera de Stock";
            Inventario inventario = new Inventario(libro.getTitulo(),libro.getStock(),estado);
            inventarioList.add(inventario);
        }

        return inventarioList;
	}
}
