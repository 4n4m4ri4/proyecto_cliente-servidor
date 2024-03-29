package serviciosWEB;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import modelo.Usuario;
import servicios.ServicioUsuarios;
import utilidadesArchivos.GestorArchivos;

@Controller
@RequestMapping("ServicioWebUsuarios/")
public class ServicioWebUsuarios {
	
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@RequestMapping("registrarUsuario")
	public ResponseEntity<String> registrarUsuario(
			@RequestParam Map<String, Object> formData,
			@RequestParam("foto") CommonsMultipartFile foto,
			HttpServletRequest request
			){
		String respuesta="ok";
		
		Gson gson = new Gson();
		JsonElement json = gson.toJsonTree(formData);
		Usuario u = gson.fromJson(json, Usuario.class);
		System.out.println("usuario a registrar: " + u.toString());
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");		
		servicioUsuarios.registrarUsuario(u);
		GestorArchivos.guardarFotoUsuario(u, foto, rutaRealDelProyecto);
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
		
	}
	@RequestMapping("identificarUsuario")
	public ResponseEntity<String> identificarUsuario(String email, String contrasena,HttpServletRequest request){
		String respuesta="";
		//comprobar en base de datos si el conjunto email pass es correcto
		Usuario u=servicioUsuarios.obtenerUsuarioPorEmailyPass(email, contrasena);
		if( u != null) {
			request.getSession().setAttribute("usuario", u);
			respuesta="ok, " + u.getNombre();
		}else {
			respuesta="error, email o contraseña incorrectos";
		}
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);	
	}

	@RequestMapping("logout")
	public ResponseEntity<String> logout(HttpServletRequest request){
		request.getSession().invalidate();
		return new ResponseEntity<String>("ok",HttpStatus.OK);	
		
	}
}
