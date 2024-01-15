package constantesSQL;

public class ConstantesSQL {
	
	public final static String SQL_OBTENER_CATEGORIAS_PARA_DESPLEGABLE= "select id, nombre from tabla_categorias order by nombre asc";
	
	public static final String SQL_OBTENER_PRODUCTOS_CARRITO = "select joya.id as joya_id,  joya.nombre,joya.marca, "
		+ "joya.precio, productocarrito.cantidad "
		+ "from joya, productocarrito "
		+ "where productocarrito.joya_id = joya.id and "
		+ "productocarrito.carrito_id = :carrito_id "
		+ "ORDER by productocarrito.id asc";
	
	public static final String BORRAR_PRODUCTOS_CARRITO = 
			"delete from productocarrito where carrito_id = :carrito_id";
	
	public static final String OBTENER_TOTAL_JOYAS = 
			"select count(id) from joya where nombre like :nombre ";
}
