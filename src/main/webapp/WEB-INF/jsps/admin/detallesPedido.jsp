<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/cssAdmin.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>


<div class="wrapperDetalles">
 
        <div class="divDetalles">
           <h2 class="titulosDet">Detalles del pedido</h2>
           <div style="margin-left:70px; margin-bottom:50px; ">
            <p><b>Nombre:</b>  ${pedido.nombreCompleto}</p>
            <p><b>Direccion:</b>  ${pedido.direccion}</p>
            <p><b>Provincia:</b>  ${pedido.provincia}</p>
            <p><b>Código postal:</b>  ${pedido.cp}</p>
            <p><b>Móvil:</b>  ${pedido.movil}</p>
            </div>
            
            
            <div class="divPagoD" style="margin-left:70px; margin-bottom:50px;">
	          <p><b>Titular tarjeta:</b>  ${pedido.titularTarjeta}</p>
	          <p><b>Número de tarjeta:</b>  ${pedido.numeroTarjeta}</p>
	      </div>
		</div>
        <div class="divProd">
        <h2 class="titulosDet">Productos del pedido</h2>
        <div class="divDetalleProd">
			<c:forEach var="pp" items="${pedido.productosPedido}">
				
				<div style="margin:0 auto;" >
				 <object style="height: 100px" data="../subidas/${pp.joya.id}.jpg?fai=${joya.fechaImagenPortada}">
    				<img style="height: 100px" src="../subidas/imagen_defecto.jpg"/>
  				 </object><br>
				<b>${pp.joya.nombre}</b>
				<p>Precio/unidad: ${pp.joya.precio} &euro;</p>
				<p>Cantidad: ${pp.cantidad}</p>
				</div>
			  
			</c:forEach>
			</div>
		</div>
		
		<div class="estadoPedi" style="margin-top:40px;">
		<h2 class="titulosDet">Estado del pedido</h2>
		<select id="select_estado" style="margin-left:50px;">
			<c:forEach var="estado" items="${estados}">
				<option 
				
					<c:if test="${ estado.key == pedido.estado }">
					    selected
					</c:if>
				
					value="${estado.key}"
				> ${estado.value} </option>
			</c:forEach>
		</select>
	</div>
	
<input type="hidden" id="id_pedido" value="${pedido.id}"/>
        
    </div><!--  .wrapper -->
	
<script type="text/javascript" src="../librerias_js/jquery.js" ></script>
<script type="text/javascript">
	$("#select_estado").change(function(e){
		//obtener el estado seleccionado y mandarlo a un servicio web
		let estado = $(this).find(":selected").val();
		let idPedido = $("#id_pedido").val();
		$.post("ServicioWebPedidosAdmin/actualizarEstadoPedido",
				{
					id: idPedido,
					estado : estado
				}
		).done(function(res){
			alert(res);
		});
	});//end change
</script>

</body>
</html>




