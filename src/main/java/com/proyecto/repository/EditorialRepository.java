package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.EditorialEntity;

@Repository
public interface EditorialRepository extends JpaRepository<EditorialEntity,Integer>{
    
}
