package com.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_autor")
public class AutorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDAutor", nullable = false)
    private Integer idAutor;

    @Column(name = "NombrAutor", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nombreAutor;

    @Column(name = "ApellidoAutor", nullable = false, columnDefinition = "VARCHAR(100)")
    private String apellidoAutor;

	public AutorEntity(Integer idAutor, String nombreAutor, String apellidoAutor) {
		super();
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.apellidoAutor = apellidoAutor;
	}

	public AutorEntity() {
		super();
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getApellidoAutor() {
		return apellidoAutor;
	}

	public void setApellidoAutor(String apellidoAutor) {
		this.apellidoAutor = apellidoAutor;
	}
    
    
}
