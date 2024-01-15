package servicios;

import java.util.List;

import modelo.Joya;


public interface ServicioJoyas {
	
	 void registrarJoya(Joya j);
	 
	 public int obtenerTotalJoyas(String nombre);
	
	 public List<Joya> obtenerJoyas(String nombre,int comienzo);
	
	 void borrarJoya(int id);
	 
	 Joya obtenerJoyaPorId(int id);
	 
	 void guardarCambiosJoya(Joya j);



}
