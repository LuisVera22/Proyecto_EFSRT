package com.proyecto.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="tb_libro")
public class LibroEntity {
	@Id
	@Column(name="ISBN", nullable = false, length = 20, insertable=false, updatable=false)//DetallePedidoEntity relation with
	
	private String ISBN;
	
	@Column(name="Titulo", unique=true, nullable = false, length = 200) //unique =true cause need a single title for each book
	private String titulo;
	
	@Column(name="Resenia", nullable=false)
	private String resenia;
	
	@Column(name="Precio", nullable=false , columnDefinition = "DECIMAL(10,2)")//might be price for book
	private Double precio;
	
	@Column(name="Stock", nullable=false)//might be stock for book
	private Integer stock;
	
	@Column(name="FechaPublicacion", nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate Fechapublicacion;
	
	@Column(name="RestriccionEdad", columnDefinition = "INT DEFAULT NULL")
	private Integer restriccionEdad;

	private String urlImagen;
	
	@ManyToOne
	@JoinColumn(name="IDAutor", nullable = false)
	private AutorEntity autorEntity;
	@ManyToOne
	@JoinColumn(name="IDEditorial", nullable = false)
	private EditorialEntity editorialEntity;
	
	@OneToMany(mappedBy = "libro", fetch = FetchType.EAGER)
	private Set<LibroCategoriaEntity> categorias = new HashSet<>();
	@Embedded
	private LibroCategoriaId id;
	
	
	
	@OneToMany(mappedBy = "libro")
    private Set<DetallePedidoEntity> detallesPedidos = new HashSet<>();

	public LibroEntity(String iSBN, String titulo, String resenia, Double precio, Integer stock,
			LocalDate fechapublicacion, Integer restriccionEdad, AutorEntity autorEntity,
			EditorialEntity editorialEntity, String urlImagen, Set<LibroCategoriaEntity> categorias,
			Set<DetallePedidoEntity> detallesPedidos) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.resenia = resenia;
		this.precio = precio;
		this.stock = stock;
		Fechapublicacion = fechapublicacion;
		this.restriccionEdad = restriccionEdad;
		this.autorEntity = autorEntity;
		this.editorialEntity = editorialEntity;
		this.categorias = categorias;
		this.detallesPedidos = detallesPedidos;
		this.urlImagen = urlImagen;
	}

	public LibroEntity() {
		super();
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResenia() {
		return resenia;
	}

	public void setResenia(String resenia) {
		this.resenia = resenia;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public LocalDate getFechapublicacion() {
		return Fechapublicacion;
	}

	public void setFechapublicacion(LocalDate fechapublicacion) {
		Fechapublicacion = fechapublicacion;
	}

	public Integer getRestriccionEdad() {
		return restriccionEdad;
	}

	public void setRestriccionEdad(Integer restriccionEdad) {
		this.restriccionEdad = restriccionEdad;
	}

	public AutorEntity getAutorEntity() {
		return autorEntity;
	}

	public void setAutorEntity(AutorEntity autorEntity) {
		this.autorEntity = autorEntity;
	}

	public EditorialEntity getEditorialEntity() {
		return editorialEntity;
	}

	public void setEditorialEntity(EditorialEntity editorialEntity) {
		this.editorialEntity = editorialEntity;
	}

	public Set<LibroCategoriaEntity> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<LibroCategoriaEntity> categorias) {
		this.categorias = categorias;
	}

	public Set<DetallePedidoEntity> getDetallesPedidos() {
		return detallesPedidos;
	}

	public void setDetallesPedidos(Set<DetallePedidoEntity> detallesPedidos) {
		this.detallesPedidos = detallesPedidos;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	
	
	
}
