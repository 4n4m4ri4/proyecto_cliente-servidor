package datos.servicioWEB;

import java.util.List;
import java.util.Map;

public class ResumenPedido {

	
	private List<Map<String, Object>> joyas;
	
	//Paso 1
	private String nombreCompleto;
	
	private String direccion;
	
	private int cp;
	
	private String movil;
	
	private String provincia;
	
	//Paso 2
	private String titularTarjeta;
	
	private String numeroTarjeta;
	
	//paso 3
	private String detalle;

	public List<Map<String, Object>> getJoyas() {
		return joyas;
	}

	public void setJoyas(List<Map<String, Object>> joyas) {
		this.joyas = joyas;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTitularTarjeta() {
		return titularTarjeta;
	}

	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
	
}
