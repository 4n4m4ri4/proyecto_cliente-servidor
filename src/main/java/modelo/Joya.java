package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Joya {
   
	@NotEmpty(message=" El nombre no puede estar vacío.")
	@Size(min=1 , max=300)
	private String nombre;
	
	@NumberFormat(style= Style.CURRENCY, pattern = "#,###.###")
	@Min(value =1, message="El precio mínimo es 1 euro")
	private double precio;
	
	@NotEmpty(message=" El material no puede estar vacío.")
	@Size(min=1 , max=100)
	@Pattern(regexp= "^[a-zA-Z áéíóúÁÉÍÓÚñÑ]{1,100}$" , message="Solo letras")
	private String material;
	
	@NumberFormat(style= Style.CURRENCY, pattern = "#,###.###")
	@Max(value= 1000, message="El peso no puede superar 1000 gramos")
	private double peso;
	
	@NotEmpty(message=" La marca no puede estar vacía.")
	@Size(min=1 , max=100)
	@Pattern(regexp= "^[a-zA-Z áéíóúÁÉÍÓÚñÑ]{1,100}$" , message="Solo letras")
	private String marca;
	
	@Size(min=1 , max=100)
	@Pattern(regexp= "^[a-zA-Z áéíóúÁÉÍÓÚñÑ]{1,100}$" , message="Solo letras")
	private String color;
	private boolean alta;
	
	@Transient //con @Transient, el siguiente campo es ignorado por hibernate
	private MultipartFile portada;
	@Transient 
	private MultipartFile foto;
	
	@Column(nullable = true)
	private Date fechaImagenPortada;
	
	@Column(nullable = true)
	private Date fechaImagenFoto;
	
	@ManyToOne(targetEntity = Categoria.class, optional = false, fetch = FetchType.EAGER)
	private Categoria categoria;
	
	@Transient
	private int idCategoria;
	

	
	@Id
	@GeneratedValue
	private int id;
	
	public Joya() {
		super();
	}

	
	public Joya(String nombre, double precio, String material, double peso, String marca, String color,Categoria categoria, boolean alta) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.material = material;
		this.peso = peso;
		this.marca = marca;
		this.color = color;
		this.categoria=categoria;
		this.alta=alta;
	}


	public Joya(int id, String nombre, double precio, String material, double peso, String marca,String color) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.material = material;
		this.peso = peso;
		this.marca = marca;
		this.color=color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public boolean isAlta() {
		return alta;
	}


	public void setAlta(boolean alta) {
		this.alta = alta;
	}


	public MultipartFile getPortada() {
		return portada;
	}


	public void setPortada(MultipartFile portada) {
		this.portada = portada;
	}


	public MultipartFile getFoto() {
		return foto;
	}


	public void setFoto(MultipartFile foto) {
		this.foto = foto;
	}


	public Date getFechaImagenFoto() {
		return fechaImagenFoto;
	}


	public void setFechaImagenFoto(Date fechaImagenFoto) {
		this.fechaImagenFoto = fechaImagenFoto;
	}


	public Date getFechaImagenPortada() {
		return fechaImagenPortada;
	}


	public void setFechaImagenPortada(Date fechaImagenPortada) {
		this.fechaImagenPortada = fechaImagenPortada;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public int getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
	

}
