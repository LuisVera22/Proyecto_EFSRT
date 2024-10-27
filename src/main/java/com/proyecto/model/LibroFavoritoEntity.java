package com.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_librosfavoritos")
public class LibroFavoritoEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDFavorito")
    private Integer idFavorito;
	
	@ManyToOne
    @JoinColumn(name = "IDCliente", nullable = false)
    private ClienteEntity cliente; 

    @ManyToOne
    @JoinColumn(name = "ISBN", nullable = false)
    private LibroEntity libro;

	public LibroFavoritoEntity(Integer idFavorito, ClienteEntity cliente, LibroEntity libro) {
		super();
		this.idFavorito = idFavorito;
		this.cliente = cliente;
		this.libro = libro;
	}

	public LibroFavoritoEntity() {
		super();
	}

	public Integer getIdFavorito() {
		return idFavorito;
	}

	public void setIdFavorito(Integer idFavorito) {
		this.idFavorito = idFavorito;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public LibroEntity getLibro() {
		return libro;
	}

	public void setLibro(LibroEntity libro) {
		this.libro = libro;
	} 
    
    
}
