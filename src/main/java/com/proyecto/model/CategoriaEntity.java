package com.proyecto.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_categoria")
public class CategoriaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDCategoria", nullable = false)
	private Integer idCategoria;
	
	@Column(name="NombreCategoria", columnDefinition = "VARCHAR(100)", nullable = false)
	private String nombreCategoria;
	
	@OneToMany(mappedBy = "categoria")
    private Set<LibroCategoriaEntity> libros = new HashSet<>();

	public CategoriaEntity(Integer idCategoria, String nombreCategoria, Set<LibroCategoriaEntity> libros) {
		super();
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
		this.libros = libros;
	}

	public CategoriaEntity() {
		super();
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Set<LibroCategoriaEntity> getLibros() {
		return libros;
	}

	public void setLibros(Set<LibroCategoriaEntity> libros) {
		this.libros = libros;
	}

	
	
	
	
}
