package com.proyecto.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibroCategoriaId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
    private Integer idCategoria;



    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibroCategoriaId that = (LibroCategoriaId) o;
        return Objects.equals(isbn, that.isbn) && Objects.equals(idCategoria, that.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, idCategoria);
    }

   
}
