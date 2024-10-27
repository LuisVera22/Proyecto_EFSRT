package com.proyecto.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_librocategoria")
public class LibroCategoriaEntity {
	
	
    @EmbeddedId	
    private LibroCategoriaId id;
    @ManyToOne
    @MapsId("isbn")
    @JoinColumn(name = "ISBN")
    private LibroEntity libro;

    @ManyToOne
    @MapsId("idCategoria")
    @JoinColumn(name = "IDCategoria")
    private CategoriaEntity categoria;

    // Constructores, getters y setters
    public LibroCategoriaEntity() {}

    public LibroCategoriaEntity(LibroCategoriaId id, LibroEntity libro, CategoriaEntity categoria) {
        this.id = id;
        this.libro = libro;
        this.categoria = categoria;
    }

    public LibroCategoriaId getId() {
        return id;
    }

    public void setId(LibroCategoriaId id) {
        this.id = id;
    }

    public LibroEntity getLibro() {
        return libro;
    }

    public void setLibro(LibroEntity libro) {
        this.libro = libro;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }
}
