<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../css/cssAdmin.css" rel="stylesheet" />

<jsp:include page="menu.jsp"></jsp:include>

<div class="contenedor">
<h1 style="margin:10px;">Usuarios: </h1>

	<button class="registroUsu"><a  href="nuevoUsuario" >Registrar un usuario</a></button>



   <ul class="cards">
   <c:forEach var="usuario" items="${usuarios}">
  <li class="user-card-item">
    <div class="user-card">
      <div class="user-card-pb card__image--fence"></div>
      <div class="user-card-img"></div>
      <div class="user-card-cont">
        <div class="user-card-title">${usuario.nombre }</div>
         <p class="user-card-text">Apellidos: ${usuario.apellidos}</p>
         <p class="user-card-text"> ${usuario.email}</p>
        <p class="user-id">Edad: ${usuario.edad}</p>
       
      </div>
      <div class="btn-row" ><button class="btn"><a style="text-decoration: none;" href="editarUsuario?idEditar=${usuario.id}">Editar</a> </button>
      <button class="btn" ><a style="text-decoration: none;" onclick="return confirm('¿Seguro?');" href="borrarUsuario?idBorrar=${usuario.id}">
      Borrar</a></button></div>
    </div>   
    
  </li>
  </c:forEach>
</ul>


</div>


