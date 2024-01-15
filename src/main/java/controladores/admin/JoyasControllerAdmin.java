package controladores.admin;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import constantes.Paginacion;
import modelo.Joya;
import servicios.ServicioCategorias;
import servicios.ServicioJoyas;
import utilidadesArchivos.GestorArchivos;



@Controller
@RequestMapping("/admin/")
public class JoyasControllerAdmin {
	

	@Autowired
	private ServicioJoyas servicioJoyas;
	
	@Autowired
	private ServicioCategorias servicioCategorias;

	@RequestMapping("gestionarJoyas")
	public String gestionarJoyas(Model model,@RequestParam(defaultValue = "") String nombre,@RequestParam(defaultValue = "0" ) String comienzo) {
		
		int comienzo_int = Integer.parseInt(comienzo);
		
		System.out.println("mostrar resultados desde: " + comienzo_int);
		
		model.addAttribute("joyas",servicioJoyas.obtenerJoyas(nombre,comienzo_int));	
		model.addAttribute("nombre",nombre);
		model.addAttribute("siguiente", 
				comienzo_int + Paginacion.RESULTADOS_POR_PAGINA);
		model.addAttribute("anterior",
				comienzo_int - Paginacion.RESULTADOS_POR_PAGINA);
		model.addAttribute("total",servicioJoyas.obtenerTotalJoyas(nombre));
		return "admin/gestionarJoyas";
	}
	@RequestMapping("borrarJoya")
	public String borrarJoya(String idBorrar, Model model) {
		servicioJoyas.borrarJoya(Integer.parseInt(idBorrar));
		return gestionarJoyas(model,"","0");
	}
	
	@RequestMapping("nuevaJoya")
	public String nuevaJoya(Model model) {
		Joya joya=new Joya();
		joya.setAlta(true);
		model.addAttribute("joya", joya);
		model.addAttribute("categorias",servicioCategorias.obtenerCategoriasParaDesplegable());
		return "admin/formRegistroJoya";
	}
	
	@RequestMapping("guardarNuevaJoya")
	public String guardarNuevaJoya(@ModelAttribute("joya") @Valid Joya joya, BindingResult br, Model model, HttpServletRequest request ) {
		if(! br.hasErrors()) {
			if(joya.getPortada().getSize() != 0) {
				joya.setFechaImagenPortada(new Date());
			}
			if(joya.getFoto().getSize() != 0) {
				joya.setFechaImagenFoto(new Date());
			}
			servicioJoyas.registrarJoya(joya);
				
			String rutaRealDelProyecto= request.getServletContext().getRealPath("");
			GestorArchivos.guardarPortadaJoya(joya, rutaRealDelProyecto);
			return gestionarJoyas(model,"","0");
		}else {
			model.addAttribute("joya", joya);
			model.addAttribute("categorias",servicioCategorias.obtenerCategoriasParaDesplegable());
			return "admin/formRegistroJoya";
		}
			
	}

	
	@RequestMapping("editarJoya")
	public String editarJoya(String idEditar, Model model) {
		Joya joya = servicioJoyas.obtenerJoyaPorId(Integer.parseInt(idEditar));
		Map<String,String> mapCategorias= servicioCategorias.obtenerCategoriasParaDesplegable();
		joya.setIdCategoria(joya.getCategoria().getId());
		model.addAttribute("joya", joya);
		model.addAttribute("categorias",mapCategorias);
		return "admin/formEditarJoya";
	}
	
	@RequestMapping("actualizarJoya")
	public String actualizarJoya(Joya joya, Model model,HttpServletRequest request) {
		if(joya.getPortada().getSize() != 0) {
			joya.setFechaImagenPortada(new Date());
		}		
		if(joya.getFoto().getSize() != 0) {
			joya.setFechaImagenFoto(new Date());
		}
		servicioJoyas.guardarCambiosJoya(joya);
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");		
		GestorArchivos.guardarPortadaJoya(joya, rutaRealDelProyecto);
		return gestionarJoyas(model,"","0");
	}
	


}
