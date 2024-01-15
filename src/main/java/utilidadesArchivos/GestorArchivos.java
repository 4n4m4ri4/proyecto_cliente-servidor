package utilidadesArchivos;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import modelo.Joya;
import modelo.Usuario;



public class GestorArchivos {
	
	public static boolean borrarPortadaJoya(String idJoya,String rutaReal) {
		File f=new File(rutaReal+"/subidas/"+idJoya+".jpg");
		if(f.delete()) {
			System.out.println("el archivo se ha borrado correctamente");
			return true;
			
		}else {
			System.out.println("no se puedo borrar el archivo");
			return false;
			
		}
	}

	public static void guardarPortadaJoya(Joya j, String rutaReal) {
		String nombreArchivo = j.getId() + ".jpg";
		String nombreArchivo2=j.getId()+"_2.jpg";
		String rutaSubidas = rutaReal + "/subidas";
		//si rutaSubidas no existe, crearla:
		File fileRutaSubidas = new File(rutaSubidas);
		if( ! fileRutaSubidas.exists() ) {
			fileRutaSubidas.mkdirs();
		}
		//si existe el archivo subido
		if(j.getPortada().getSize() > 0) {
			try {
				j.getPortada().transferTo(new File(rutaSubidas,nombreArchivo));
				
				System.out.println("archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("no pude mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("se subio una joya sin portada, no hay problema,"
					+ "de momento la imagen es opcional");
		}
		
		if(j.getFoto().getSize() > 0) {
			try {
				j.getFoto().transferTo(new File(rutaSubidas,nombreArchivo2));
				System.out.println("archivo2 movido a: " + rutaSubidas);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("no pude mover el archivo2 a la ruta de subidas");
			}
		}else {
			System.out.println("se subio una joya sin foto, no hay problema,"
					+ "de momento la imagen es opcional");
		}
		
	}
	public static void guardarFotoUsuario(Usuario u, CommonsMultipartFile foto, String rutaRealDelProyecto) {
		String nombreArchivo = "u" + u.getId() + ".jpg";
		String rutaSubidas = rutaRealDelProyecto + "/subidas";
		//si rutaSubidas no existe, crearla:
		File fileRutaSubidas = new File(rutaSubidas);
		if( ! fileRutaSubidas.exists() ) {
			fileRutaSubidas.mkdirs();
		}
		//si existe el archivo subido
		if(foto.getSize() > 0) {
			try {
				foto.transferTo(new File(rutaSubidas,nombreArchivo));
				System.out.println("archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("no pude mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("se registro sin foto, no pasa nada"
					+ "de momento la imagen es opcional");
		}
	}//end guardarFotoUsuario
	
	
}
