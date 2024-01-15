package servicios;

import java.util.List;

import datos.servicioWEB.ResumenPedido;
import modelo.Pedido;
import modelo.Usuario;

public interface ServicioPedidos {
	
	void procesarPaso1(String nombreCompleto,String direccion,int cp,String movil,String provincia, Usuario usuario);

	void procesarPaso2(String titular, String numero, Usuario u);

	void procesarPaso3(String detalle, Usuario u);

	ResumenPedido obtenerResumenDelPedido(Usuario u);

	void confirmarPedido(Usuario usuario);

	List<Pedido> obtenerPedidos();
	
	Pedido obtenerPedidoPorId(int idPedido);
	
	void actualizarEstadoPedido(int idPedido, String estado);


}
