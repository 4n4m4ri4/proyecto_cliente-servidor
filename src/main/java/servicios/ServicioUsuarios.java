package servicios;

import java.util.List;

import modelo.Usuario;

public interface ServicioUsuarios {

	void registrarUsuario(Usuario u);
	
	List<Usuario> obtenerUsuarios();
	
	void borrarUsuario(int id);

	Usuario obtenerUsuarioPorId(int idUsuario);
	
	void guardarCambiosUsuario(Usuario u);
	
	Usuario obtenerUsuarioPorEmail(String email);

	Usuario obtenerUsuarioPorEmailyPass(String email, String contrasenia);

}
