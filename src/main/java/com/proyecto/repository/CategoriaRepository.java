package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.CategoriaEntity;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
    
}
