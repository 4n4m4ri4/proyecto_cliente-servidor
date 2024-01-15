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



<div class="wrapperEditarJoya">
<h2  class="form-signin-heading">Datos de la joya a editar</h2>
<springform:form modelAttribute="joya" action="actualizarJoya" onsubmit="return confirm('¿Seguro?');" enctype="multipart/form-data" class="formSp">  

	Nombre <br>
	<springform:input path="nombre" class="forma"/> <br><br>
	Precio<br> <springform:input path="precio" class="forma"/> <br><br>
	Material<br> <springform:input path="material" class="forma"/> <br><br>
	Peso<br> <springform:input path="peso" class="forma"/> <br><br>
	Marca<br> <springform:input path="marca" class="forma"/> <br><br>	
	Color<br> <springform:input path="color" class="forma"/> <br><br>
	Categoria<br><br> <springform:select path="idCategoria">
	    <springform:options items="${categorias}"/>
	</springform:select><br><br>
	<div style="margin-top:20px;">
	Fotos<br><br> <springform:input path="portada" type="file"/><br><br>
	   <springform:input path="foto" type="file" />
	 <br><br>
	</div>
	<springform:hidden path="id"/>
	
	<input class="botonEditUsu" type="submit" value="GUARDAR CAMBIOS" />

</springform:form>
  </div>

</body>
</html>