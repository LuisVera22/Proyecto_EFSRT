package com.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_editorial")
public class EditorialEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDEditorial", nullable = false)
    private Integer idEditorial;

    @Column(name = "NombreEditorial", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nombreEditorial;

	public EditorialEntity(Integer idEditorial, String nombreEditorial) {
		super();
		this.idEditorial = idEditorial;
		this.nombreEditorial = nombreEditorial;
	}

	public EditorialEntity() {
		super();
	}

	public Integer getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(Integer idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getNombreEditorial() {
		return nombreEditorial;
	}

	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}
    
    
}
