<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>



<div class="wrapperRegJoya">
<h3 class="form-signin-heading">Inserta datos:</h3>
<springform:form modelAttribute="joya" action="guardarNuevaJoya" enctype="multipart/form-data" class="formRegJoya">

	Nombre <br> <springform:input path="nombre" class="formaRegJ"/> <br>
	 <span style="color: red;"> <springform:errors path="nombre"/> </span>
	<br><br>
	
	Precio<br><springform:input path="precio" class="formaRegJ"/><br>
	<span style="color: red;"> <springform:errors path="precio"/> </span>
	 <br><br>
	
	Material<br> <springform:input path="material" class="formaRegJ"/> <br>
	<span style="color: red;"> <springform:errors path="material"/> </span>
	<br><br>
	
	Peso<br> <springform:input path="peso" class="formaRegJ"/> <br>
	<span style="color: red;"> <springform:errors path="peso"/> </span>
	<br><br>
	
	Marca<br> <springform:input path="marca" class="formaRegJ"/><br>
	<span style="color: red;"> <springform:errors path="marca"/> </span>
	 <br><br>	
	
	Color<br> <springform:input path="color" class="formaRegJ"/><br>
	 <span style="color: red;"> <springform:errors path="color"/> </span>
	 <br><br>
	
	Alta: <springform:checkbox path="alta" class="formaRegJ"/> <br><br>
	
    Categoria<br><br><springform:select path="idCategoria">
	    <springform:options items="${categorias}"/>
	</springform:select><br><br>
	
	
	Fotos<br><br> <springform:input path="portada" type="file" /> <br><br>
	<springform:input path="foto" type="file" /> <br><br>
	
	<input  class="botonEditUsu" type="submit" value="REGISTRAR" />

</springform:form>

</div>
</body>
</html>