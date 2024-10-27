package com.proyecto.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class DetallePedidoId implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer idPedido; 
    private String isbn;
	public DetallePedidoId(Integer idPedido, String isbn) {
		super();
		this.idPedido = idPedido;
		this.isbn = isbn;
	}
	public DetallePedidoId() {
		super();
	}
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
    
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetallePedidoId that = (DetallePedidoId) o;
        return Objects.equals(idPedido, that.idPedido) && Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, isbn);
    }
    
}
