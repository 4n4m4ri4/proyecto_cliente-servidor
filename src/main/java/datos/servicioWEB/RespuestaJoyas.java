package datos.servicioWEB;

import java.util.List;

import modelo.Joya;


public class RespuestaJoyas {
	private int total;
	private List<Joya> joyas;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Joya> getJoyas() {
		return joyas;
	}
	public void setJoyas(List<Joya> joyas) {
		this.joyas = joyas;
	}
	
	

}
