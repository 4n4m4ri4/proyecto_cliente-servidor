let val_nombre=/^[a-z áéíóúñ]{1,100}$/i;
let val_apellidos=/^[a-z áéíóúñ]{1,200}$/i;
let val_edad=/^[0-9]{1,3}$/;
let val_pass=/^[a-z0-9áéíóúñ_-]{1,50}$/i;
let val_email=/^([a-z0-9_.-]+)@([a-z0-9_.-]+)\.([a-z.]{2,6})$/i;


function validarNombre(nombre){
	if(val_nombre.test(nombre)){
		return true;
	}else{
		alert("Nombre incorrecto");
		return false;
	}
}
function validarApellidos(apellidos){
	if(val_apellidos.test(apellidos)){
		return true;
	}else{
		alert("Apellidos incorrectos");
		return false;
	}
}
function validarEdad(edad){
	if(val_edad.test(edad)){
		return true;
	}else{
		alert("Edad incorrecta");
		return false;
	}
}
function validarEmail(email){
	if(val_email.test(email)){
		return true;
	}else{
		alert("Email incorrecto");
		return false;
	}
}
function validarPass(contrasena){
	if(val_pass.test(contrasena)){
		return true;
	}else{
		alert("Contraseña incorrecta");
		return false;
	}
}
