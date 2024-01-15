package serviciosImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantes.Paginacion;
import constantesSQL.ConstantesSQL;
import modelo.Categoria;
import modelo.Joya;
import servicios.ServicioJoyas;

@Service
@Transactional
public class ServicioJoyasImpl implements ServicioJoyas{
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void registrarJoya(Joya j) {
		Categoria c=(Categoria)sessionFactory.getCurrentSession().get(Categoria.class,j.getIdCategoria());
		j.setCategoria(c);
		sessionFactory.getCurrentSession().save(j);
		
	}

	@Override
	public List<Joya> obtenerJoyas(String nombre,int comienzo) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Joya.class);
		//c.add(Restrictions.like("nombre", "a%"));
		c.add(Restrictions.like("nombre", "%"+nombre+"%"));
	
		c.setFirstResult(comienzo);
		c.setMaxResults(Paginacion.RESULTADOS_POR_PAGINA);
		return c.list();
	
	}

	@Override
	public void borrarJoya(int id) {
		Joya j=(Joya) sessionFactory.getCurrentSession().get(Joya.class, id);
		sessionFactory.getCurrentSession().delete(j);
		
	}

	@Override
	public Joya obtenerJoyaPorId(int id) {
		return (Joya) sessionFactory.getCurrentSession().get(Joya.class,id);
	
	}

	@Override
	public void guardarCambiosJoya(Joya j) {
		Categoria c=(Categoria)sessionFactory.getCurrentSession().get(Categoria.class, j.getIdCategoria());
		j.setCategoria(c);
		sessionFactory.getCurrentSession().merge(j);
		
	}

	@Override
	public int obtenerTotalJoyas(String nombre) {
		SQLQuery query = sessionFactory.getCurrentSession().
				createSQLQuery(ConstantesSQL.OBTENER_TOTAL_JOYAS);
		query.setParameter("nombre", "%"+nombre+"%");
		
		return Integer.parseInt(query.list().get(0).toString());
	}

	

}
