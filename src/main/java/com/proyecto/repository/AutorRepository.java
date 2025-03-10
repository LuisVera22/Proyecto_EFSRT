package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.AutorEntity;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Integer> {
    
}
