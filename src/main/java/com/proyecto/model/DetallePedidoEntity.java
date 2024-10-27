package com.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_detallepedido")
public class DetallePedidoEntity {
	
	@EmbeddedId
    private DetallePedidoId id;
	
	@Column(name="cantidad", nullable=false)
	private Integer cantidad;
	
	@Column(name="precio", nullable=false)
	private Double Precio;
	
	@ManyToOne
    @MapsId("idPedido") 
    @JoinColumn(name = "IDPedido", nullable = false)
    private PedidoEntity pedido;

    @ManyToOne
    @MapsId("isbn") 
    @JoinColumn(name = "ISBN", nullable = false)
    private LibroEntity libro;
    
	public DetallePedidoEntity(DetallePedidoId id, Integer cantidad, Double precio, PedidoEntity pedido,
			LibroEntity libro) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		Precio = precio;
		this.pedido = pedido;
		this.libro = libro;
	}

	public DetallePedidoEntity() {
		super();
	}

	public DetallePedidoId getId() {
		return id;
	}

	public void setId(DetallePedidoId id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public LibroEntity getLibro() {
		return libro;
	}

	public void setLibro(LibroEntity libro) {
		this.libro = libro;
	}
    
    
}
