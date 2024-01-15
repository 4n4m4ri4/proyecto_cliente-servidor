package serviciosImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantes.EstadosPedido;
import constantesSQL.ConstantesSQL;
import datos.servicioWEB.ResumenPedido;
import modelo.Carrito;
import modelo.Pedido;
import modelo.ProductoCarrito;
import modelo.ProductoPedido;
import modelo.Usuario;
import servicios.ServicioCarrito;
import servicios.ServicioPedidos;

@Service
@Transactional
public class ServicioPedidosImpl implements ServicioPedidos {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ServicioCarrito servicioCarrito;
	
	
	private Pedido obtenerPedidoActual(Usuario usuario) {
		Usuario uBaseDatos = (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, usuario.getId());

		Object pedidoEnProceso = sessionFactory.getCurrentSession().createCriteria(Pedido.class)
				.add(Restrictions.eqOrIsNull("estado", EstadosPedido.EN_PROCESO))
				.add(Restrictions.eq("usuario.id", usuario.getId())).uniqueResult();

		Pedido p = null;
		if (pedidoEnProceso == null) {
			p = new Pedido();
			p.setEstado(EstadosPedido.EN_PROCESO);
			p.setUsuario(uBaseDatos);
		} else {
			p = (Pedido) pedidoEnProceso;
		}
		return p;
	}// end obtenerPedidoActual
	

	@Override
	public void procesarPaso1(String nombreCompleto, String direccion,int cp,String movil, String provincia, Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);		
		
		p.setUsuario(usuario);
		p.setNombreCompleto(nombreCompleto);
		p.setDireccion(direccion);
		p.setCp(cp);
		p.setProvincia(provincia);
		p.setMovil(movil);
		sessionFactory.getCurrentSession().save(p);		
		
	}
	

	@Override
	public void procesarPaso2(String titular, String numero, Usuario u) {
		Pedido p = obtenerPedidoActual(u);
		p.setTitularTarjeta(titular);
		p.setNumeroTarjeta(numero);
		sessionFactory.getCurrentSession().update(p);
		
	}


	@Override
	public void procesarPaso3(String detalle, Usuario u) {
		Pedido p = obtenerPedidoActual(u);
		p.setDetalle(detalle);
		sessionFactory.getCurrentSession().update(p);
		
	}

	@Override
	public ResumenPedido obtenerResumenDelPedido(Usuario u) {
		ResumenPedido resumen = new ResumenPedido();
		Pedido p = obtenerPedidoActual(u);
		resumen.setNombreCompleto(p.getNombreCompleto());
		resumen.setDireccion(p.getDireccion());
		resumen.setProvincia(p.getProvincia());
		resumen.setMovil(p.getMovil());
		resumen.setTitularTarjeta(p.getTitularTarjeta());
		resumen.setNumeroTarjeta(p.getNumeroTarjeta());
		resumen.setCp(p.getCp());
		resumen.setDetalle(p.getDetalle());
		
		resumen.setJoyas(
				servicioCarrito.obtenerProductoCarrito(u)
				);
		
		return resumen;
	}

	@Override
	public void confirmarPedido(Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		Usuario uBaseDatos = 
		(Usuario)
		sessionFactory.getCurrentSession().get(Usuario.class, usuario.getId());
		//pasar los productos del carrito a producto pedido
		Carrito c = uBaseDatos.getCarrito();
		if(c != null) {
			for(ProductoCarrito pc : c.getProductosCarrito()) {
				ProductoPedido pp = new ProductoPedido();
				pp.setCantidad(pc.getCantidad());
				pp.setJoya(pc.getJoya());
				p.getProductosPedido().add(pp);
				pp.setPedido(p);
				sessionFactory.getCurrentSession().save(pp);
			}
		}
		//borrar los productos del carrito
		SQLQuery query = 
				sessionFactory.getCurrentSession().createSQLQuery(
					ConstantesSQL.BORRAR_PRODUCTOS_CARRITO
				);
		query.setParameter("carrito_id", c.getId());
		query.executeUpdate();
		//finalizamos pedido
		p.setEstado(EstadosPedido.COMPLETADO);
		sessionFactory.getCurrentSession().update(p);
	}//end confirmarPedido
	

	@Override
	public List<Pedido> obtenerPedidos() {
		List<Pedido> pedidos = sessionFactory.getCurrentSession().createQuery("from Pedido").list();
		return pedidos;
	}

	@Override
	public Pedido obtenerPedidoPorId(int idPedido) {
		return (Pedido)sessionFactory.getCurrentSession().get(Pedido.class, 
				idPedido);
	}

	@Override
	public void actualizarEstadoPedido(int idPedido, String estado) {
		Pedido p = obtenerPedidoPorId(idPedido);
		p.setEstado(estado);
		sessionFactory.getCurrentSession().update(p);
		
	}
	

}
