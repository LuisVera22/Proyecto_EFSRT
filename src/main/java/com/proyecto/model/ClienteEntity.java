package com.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="tb_cliente")
public class ClienteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDCliente",nullable = false)
	private Integer idCliente;
	@Column(name="NombreCliente", nullable = false, columnDefinition = "VARCHAR(100)")
	private String nombreCliente;
	@Column(name="ApellidoCliente", nullable = false, columnDefinition = "VARCHAR(100)")
	private String apellidoCliente;
	@Column(name="Email", nullable = false, columnDefinition = "VARCHAR(100)", unique = true)
	private String email;
	@Column(name="Contrasenia", nullable = false, columnDefinition = "VARCHAR(255)")
	private String contrasenia;
	
	@Column(name="imagen_cliente", nullable=false)
	private String urlImagen;
	
	
	
	public ClienteEntity(Integer idCliente, String nombreCliente, String apellidoCliente, String email,
			String contrasenia, String urlImagen) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.email = email;
		this.contrasenia = contrasenia;
		this.urlImagen = urlImagen;
	}
	
	public ClienteEntity() {
		super();
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	
}
