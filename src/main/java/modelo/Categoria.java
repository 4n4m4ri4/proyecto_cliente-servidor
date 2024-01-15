package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_categorias")
public class Categoria {

		
		private String nombre;
		
		
		@Id
		@GeneratedValue
		private int id;
		
		
		public Categoria() {
			super();
		}


		public Categoria(String nombre) {

			this.nombre = nombre;
		}


	

		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}
		
		
		
		
}
