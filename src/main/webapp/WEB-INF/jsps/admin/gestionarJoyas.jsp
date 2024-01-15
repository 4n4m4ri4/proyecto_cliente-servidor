<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<div class="cabeceraJoyas"> 
<h1 style="margin:10px;">Joyas: </h1>


     <button class="registroUsu"><a  href="nuevaJoya" >Añadir Nueva Joya</a></button>

     
<div class="buscadorjoyas">
	<form action="gestionarJoyas">
		 <input class="buscaNombre" type="text" name="nombre" value="${nombre}" placeholder="Busca..." />
		<input class="buscaJoya" type="submit" value="BUSCAR">
	</form>
</div>
     
     
     
<div style="text-align: center;" class="paginaJo">
	 Total joyas: ${total}<br><br>
	
	<c:if test="${ anterior >= 0 }">
	
	<a class="pagJoya"  href="gestionarJoyas?comienzo=${anterior}&nombre=${nombre}"><img class="imgPagi" src="../assets/atras.png"/> Anterior </a> 
	
	</c:if>
	
	&nbsp;&nbsp;&nbsp;&nbsp;
	
	<c:if test="${ siguiente < total }">

		<a class="pagJoya"  href="gestionarJoyas?comienzo=${siguiente}&nombre=${nombre}"> Siguiente <img class="imgPagi" src="../assets/tocar.png"/></a>

	</c:if>
	
	
</div>
</div>

<div class="contenedorJoyas">
<c:forEach var="joya" items="${joyas}">
  <div class="product">
    <div class="img-container">
      <object style="height: 100px" data="../subidas/${joya.id}.jpg?fai=${joya.fechaImagenPortada}">
    <img style="height: 100px" src="../subidas/imagen_defecto.jpg"/>
   </object>
   </div>
    <div class="img-container">
   <object style="height: 100px" data="../subidas/${joya.id}_2.jpg?fai=${joya.fechaImagenFoto}">
    <img style="height: 100px" src="../subidas/imagen_defecto.jpg"/>
   </object>
   </div>
 
    <div class="product-info">
      <div class="product-content">
        <h1>${joya.nombre }</h1>
        <p id="price">${joya.precio} &euro;</p>
        <p>${joya.marca}</p>
        <ul>
          <li>Categoría: ${joya.categoria.nombre}</li>
          <li>Color: ${joya.color}</li>
          <li>Peso: ${joya.peso} gramos</li>
        </ul>
        <div class="buttons">
          <a class="button buy" href="editarJoya?idEditar=${joya.id}">Editar</a>
          <a class="button add" onclick="return confirm('¿Seguro?');" href="borrarJoya?idBorrar=${joya.id}">Borrar</a>
          <a class="button buy" href="agregarIdioma?idJoya=${joya.id}"onclick="alert('mostrar formulario para registrar para la joya textos en otro idioma'); return false;">
          Agregar texto en otro idioma</a>
          
        </div>
      </div>
    </div>
  </div>
 </c:forEach>
  
</div>
</body>
</html>