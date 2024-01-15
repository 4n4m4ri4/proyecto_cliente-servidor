package modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Usuario {
	
	@NotEmpty(message=" El nombre no puede estar vacío.")
	@Pattern(regexp= "^[a-zA-Z áéíóúÁÉÍÓÚñÑ]{1,100}$" , message="Solo letras")
	@Size(min=1 , max=100)
	private String nombre;
	
	@NotEmpty(message=" Los apellidos no pueden estar vacíos.")
	@Pattern(regexp= "^[a-zA-Z áéíóúÁÉÍÓÚñÑ]{1,100}$" , message="Solo letras")
	@Size(min=1 , max=200)
	private String apellidos;
	

	private int edad;
	@Column(unique = true)

	@NotEmpty(message=" El email no puede estar vacío.")
	@Pattern(regexp= "^([a-z0-9_.-]+)@([a-z0-9_.-]+)\\.([a-z.]{2,6})$" , message="Solo letras,números,guiones bajos,guion y puntos")
	private String email;
	
	@NotEmpty(message="La contraseña no puede estar vacía.")
	@Pattern(regexp= "^[a-z0-9áéíóúñ_-]{1,50}$" , message="Solo letras,números,guion y guion bajo")
	private String contrasena;
	
	@OneToOne
	private Carrito carrito;
	
	
	@Id
	@GeneratedValue
	private int id;
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellidos, int edad, String email, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.email = email;
		this.contrasena = contrasena;
	}

	public Usuario(int id, String nombre, String apellidos, int edad, String email, String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.email = email;
		this.contrasena = contrasena;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", email="
				+ email + ", contrasena=" + contrasena + "]";
	}
	
	
	

}
