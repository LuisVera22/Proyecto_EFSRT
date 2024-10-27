package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    
}
