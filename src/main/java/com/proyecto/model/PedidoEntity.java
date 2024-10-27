package com.proyecto.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Check;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_pedido")
@Check(constraints = "estado IN ('Pendiente', 'Entregado', 'Rechazado')")
public class PedidoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPedido")
	private Integer idpedido;
	
	@Column(name = "FechaPedido", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechapedido;
	
	@Column(name="estado", nullable = false)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="IDCliente", nullable = false)
	private ClienteEntity clienteEntity;
	
	@OneToMany(mappedBy = "pedido")
    private Set<DetallePedidoEntity> detallesPedidos = new HashSet<>();

	public PedidoEntity(Integer idpedido, LocalDate fechapedido, String estado, ClienteEntity clienteEntity,
			Set<DetallePedidoEntity> detallesPedidos) {
		super();
		this.idpedido = idpedido;
		this.fechapedido = fechapedido;
		this.estado = estado;
		this.clienteEntity = clienteEntity;
		this.detallesPedidos = detallesPedidos;
	}

	public PedidoEntity() {
		super();
	}

	public Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}

	public LocalDate getFechapedido() {
		return fechapedido;
	}

	public void setFechapedido(LocalDate fechapedido) {
		this.fechapedido = fechapedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ClienteEntity getClienteEntity() {
		return clienteEntity;
	}

	public void setClienteEntity(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
	}

	public Set<DetallePedidoEntity> getDetallesPedidos() {
		return detallesPedidos;
	}

	public void setDetallesPedidos(Set<DetallePedidoEntity> detallesPedidos) {
		this.detallesPedidos = detallesPedidos;
	}

	
	
	
}
