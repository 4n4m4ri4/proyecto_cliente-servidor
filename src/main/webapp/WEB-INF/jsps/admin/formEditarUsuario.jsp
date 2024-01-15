<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/cssAdmin.css">
</head>
<body>


<jsp:include page="menu.jsp"></jsp:include>


<div class="wrapperEditarUsu">
<h2  class="form-signin-heading">Datos del usuario a editar</h2>
<springform:form modelAttribute="usuario" action="actualizarUsuario" onsubmit="return confirm('¿Seguro?');" class="form-signin">  

	Nombre <br>
	<springform:input path="nombre" class="form-control"/> <br><br>
	Apellidos<br> <springform:input path="apellidos" class="form-control"/> <br><br>
	Edad<br> <springform:input path="edad" class="form-control"/> <br><br>
	Email<br> <springform:input type="email" path="email" class="form-control"/> <br><br>	
	Contraseña<br> <springform:input path="contrasena" class="form-control"/> <br>
	
	<springform:hidden path="id"/><br>
	
	<input class="botonEditUsu" type="submit" value="GUARDAR CAMBIOS" />


</springform:form>
  </div>

</body>
</html>