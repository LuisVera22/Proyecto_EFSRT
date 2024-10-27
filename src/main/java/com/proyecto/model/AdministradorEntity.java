package com.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_administrador")
public class AdministradorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdAdmin", nullable = false)
    private Integer IdAdmin;

    @Column(name="NombreAdmin", nullable = false, length = 100)
    private String nombreAdmin;

    @Column(name="ApellidoAdmin", nullable = false, length = 100)
    private String apellidoAdmin;

    @Column(name="Email", nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name="Contrasenia", nullable = false, length = 255)
    private String contrasenia;
    @Column(name ="fotoAdmin", nullable =false)
    private String foto;

    

	public AdministradorEntity(Integer idAdmin, String nombreAdmin, String apellidoAdmin, String email,
			String contrasenia, String foto) {
		super();
		IdAdmin = idAdmin;
		this.nombreAdmin = nombreAdmin;
		this.apellidoAdmin = apellidoAdmin;
		this.email = email;
		this.contrasenia = contrasenia;
		this.foto = foto;
	}

	public AdministradorEntity() {
		super();
	}

	public Integer getIdAdmin() {
		return IdAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		IdAdmin = idAdmin;
	}

	public String getNombreAdmin() {
		return nombreAdmin;
	}

	public void setNombreAdmin(String nombreAdmin) {
		this.nombreAdmin = nombreAdmin;
	}

	public String getApellidoAdmin() {
		return apellidoAdmin;
	}

	public void setApellidoAdmin(String apellidoAdmin) {
		this.apellidoAdmin = apellidoAdmin;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "AdministradorEntity [IdAdmin=" + IdAdmin + ", nombreAdmin=" + nombreAdmin + ", apellidoAdmin="
				+ apellidoAdmin + ", email=" + email + ", contrasenia=" + contrasenia + ", foto=" + foto + "]";
	}
    
    
	
    
    
}
