<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<h3 style="margin-top:20px; font-size:30px; text-align:center;">Listado de pedidos: </h3><br>


<div style="align-items:center;
  display: flex;
  flex-wrap: wrap;
  list-style: none;
  margin:0 auto;
  text-align:center;
  width: 90%;">
<c:forEach var="pedido" items="${pedidos}">
<div class="wrapper">


 
        
        <h1 class="order-title">${pedido.nombreCompleto}</h1>
       
      <table class="order-details">
        <tbody>
          <tr>
            <td class="order-item-name">${pedido.direccion}</td>
          </tr>
          <tr>
            <td class="order-item-name">Estado: ${pedido.estado}</td>
          
          </tr>
        </tbody>
      </table><!--  .order-details -->
      <div style="margin-top:20px;"><a class="botonDet"  href="verDetallesPedido?id=${pedido.id}">Ver detalles</a></div>
      
        
    </div><!--  .wrapper -->
</c:forEach>
</div>
</body>
</html>