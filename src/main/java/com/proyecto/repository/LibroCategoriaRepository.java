package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.LibroCategoriaEntity;
import com.proyecto.model.LibroCategoriaId;

@Repository
public interface LibroCategoriaRepository extends JpaRepository<LibroCategoriaEntity, LibroCategoriaId>{

}
