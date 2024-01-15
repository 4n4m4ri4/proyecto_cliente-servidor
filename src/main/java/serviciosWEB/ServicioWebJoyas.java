package serviciosWEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import datos.servicioWEB.RespuestaJoyaId;
import datos.servicioWEB.RespuestaJoyas;
import servicios.ServicioJoyas;


@Controller
@RequestMapping("ServicioWebJoyas/")
public class ServicioWebJoyas {

	
	@Autowired
	private ServicioJoyas servicioJoyas;
	
	@RequestMapping("obtenerJoyas")
	public ResponseEntity<String> obtenerJoyas(@RequestParam(defaultValue = "") String nombre,  @RequestParam(defaultValue = "0" ) String comienzo){
		RespuestaJoyas rj = new RespuestaJoyas();
		rj.setJoyas(servicioJoyas.obtenerJoyas(nombre,Integer.parseInt(comienzo)));
		rj.setTotal(servicioJoyas.obtenerTotalJoyas(nombre));		
		String respuesta = new Gson().toJson(rj);

		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
		
	}
	@RequestMapping("obtenerJoyaPorId")
	public ResponseEntity<String> obtenerJoyaPorId(@RequestParam(defaultValue = "0") String id){
		RespuestaJoyaId rj=new RespuestaJoyaId();
		rj.setJoya(servicioJoyas.obtenerJoyaPorId(Integer.parseInt(id)));
		String respuesta= new Gson().toJson(rj);
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);		
	}
	
}
