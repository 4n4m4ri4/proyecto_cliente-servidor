package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import serviciosSetUp.InterfazSetUp;

@Controller
public class ControladorInicio {
	
	@Autowired
   private InterfazSetUp servicioSetUp;

	@RequestMapping("/inicio")
	public String inicio() {
		System.out.println("Codigo de idioma actual: " + LocaleContextHolder.getLocale());
		servicioSetUp.setUp();
		return "inicio";
	}
	
}
