package serviciosWEB;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import modelo.Usuario;
import servicios.ServicioCarrito;

@Controller
@RequestMapping("ServicioWebCarrito/")
public class ServicioWebCarrito {
	
	@Autowired
	private ServicioCarrito servicioCarrito;

	@RequestMapping("agregarJoya")
	public ResponseEntity<String> agregarJoya(int idProducto,int cantidad,String marca, HttpServletRequest request){
		String respuesta= "agregar el producto de id: " + idProducto +
				" cantidad: " + cantidad + "marca: " + marca + 
				" al carrito del usuario: " + 
				((Usuario)request.getSession().getAttribute("usuario")).getNombre();
		//vamos a hacerlo:
		servicioCarrito.agregarProducto(
				(Usuario)request.getSession().getAttribute("usuario"),
				 idProducto, 
				 cantidad,
				 marca);
		respuesta = "producto agregado al carrito correctamente";
		
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
	@RequestMapping("obtenerProductosCarrito")
	public ResponseEntity<String> obtenerProductosCarrito(HttpServletRequest request){
		String respuesta = "";
		
		respuesta = new Gson().toJson( 
				servicioCarrito.obtenerProductoCarrito(
					(Usuario)request.getSession().getAttribute("usuario")
						));
		
		
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}//end obtenerProductosCarrito
}
