<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/cssAdmin.css">
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>


<div class="wrapperRegistroUsu">
<h3 class="form-signin-heading" >Inserta datos:</h3>
<springform:form modelAttribute="usuario" action="guardarNuevoUsuario" class="formRegUsu">

	Nombre<br> <springform:input path="nombre" class="formReg"/> <br><br>
	<span style="color: red;"> <springform:errors path="nombre"/></span><br>
	Apellidos<br> <springform:input path="apellidos" class="formReg"/> <br><br>
	<span style="color: red;"> <springform:errors path="apellidos"/></span><br>
	Edad<br> <springform:input path="edad" class="formReg"/> <br><br>
	
	Email<br> <springform:input type="email" path="email" class="formReg"/> <br><br>
	<span style="color: red;"> <springform:errors path="email"/></span><br>
	Contraseña<br> <springform:input path="contrasena" class="formReg"/> <br><br>	
	<span style="color: red;"> <springform:errors path="contrasena"/></span><br>
	
	<input class="botonEditUsu" type="submit" value="REGISTRARME" />

</springform:form>
</div>

</body>
</html>