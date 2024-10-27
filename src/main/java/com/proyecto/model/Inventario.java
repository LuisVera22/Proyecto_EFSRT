package com.proyecto.model;

public class Inventario {
	private String titulo;
	private Integer stock;
	private String estado;
	public Inventario(String titulo, Integer stock, String estado) {
		super();
		this.titulo = titulo;
		this.stock = stock;
		this.estado = estado;
	}
	public Inventario() {
		super();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
