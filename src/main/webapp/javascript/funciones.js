function mostrar_productos(){
	$("#contenedor").html(plantillas.productos);
	comienzo = 0;
	titulo_buscar = "";
	$("#buscador_titulo").keyup(
		function(){
			comienzo=0;
			titulo_buscar = this.value;
			refresca_listado();
		}
	);
	$("#enlace_anterior").click(
		function(){
			comienzo -= 5
			refresca_listado();
		}
	);//end click enlace anterior
	$("#enlace_siguiente").click(
		function(){
			comienzo += 5; 
			refresca_listado();
		}	
	);	
	refresca_listado();
}
function refresca_listado(){
	
	if( comienzo <= 0 ){
		$("#enlace_anterior").hide();
	}else{
		$("#enlace_anterior").show();
	}
	
	$.get("ServicioWebJoyas/obtenerJoyas",{
		nombre: titulo_buscar,
		comienzo: comienzo
	}).done( 
		function(res){
			res=JSON.parse(res);
			let joyas = res.joyas;
			let total_joyas = res.total;
			
			if( comienzo + 10 > total_joyas ){
				$("#enlace_siguiente").hide();
			}else{
				$("#enlace_siguiente").show();
			}
						
			$("#productos_listado").html(Mustache.render(plantillas.joyas_listado,joyas));
			$("#total_joyas").html(total_joyas);
			$(".enlace_detalles").click(mostrar_detalles);//end click detales
		
			
		}
	);//end get obtenerLibros
}//end refresca_listado

function mostrar_detalles(){
	let id = $(this).attr("id_producto");
	$.get("ServicioWebJoyas/obtenerJoyaPorId",{
		id:id
	}).done(
		function(res){
			res=JSON.parse(res);
			let joya=res.joya;
			$("#contenedor").html(Mustache.render(plantillas.detalles_producto,joya));
			$(".enlace_comprar").click(comprar_producto);
			
		}
		
	)
	
}

function comprar_producto(){

	if(nombre_login == ""){
		alert("Debes identificarte para poder comprar");
	}else{
		//asi obtengo la id del producto a agregar al carrito
		let id = $(this).attr("id_producto");
		var cantidad = $("#input-cantidad-"+id).val();
		
		//para hacer un post con jquery es mas comodo 
		//lo siguiente:
		$.get("ServicioWebCarrito/agregarJoya",
			{
				idProducto: id,
				cantidad: cantidad
			}
		).done(function(res){
			alert(res);
		});//end post
	}
	
}//end comprar_producto

function identificar_usuario(){
	var email= $("#emailLogin").val();
	var contrasena= $("#contrasenaLogin").val();
	$.ajax("ServicioWebUsuarios/identificarUsuario",{
		type:"post",
		data: "email="+email+"&contrasena="+contrasena,
		success: function(res){
			var respuesta=res.split(",")[0];
			var mensaje=res.split(",")[1];
			if(respuesta=="ok"){
				
				if($("#recordarDatos").prop("checked")){
					Cookies.set('emailLogin',email,{expires:100});
					Cookies.set('contrasenaLogin',contrasena,{expires:100});
				}
				
				alert("bienvenido " + mensaje + " ya puedes comprar");
				nombre_login=mensaje;
				mostrar_productos()
				$("#inicio_span_nombre_usuario").html("  Hola " + nombre_login);
				$("#logout").show();
			}else if(respuesta == "error"){
				alert(mensaje);
			}
		}//end success
	});
}
function mostrar_productos_carrito(){
	
	if(nombre_login == ""){
		alert("debes identificarte para acceder a tu carrito");
		return;
	}
	
	$.getJSON("ServicioWebCarrito/obtenerProductosCarrito",function(res){
		console.log(res);
		let joyas=res;
		if(res==null){
			alert("No tiene productos en el carrito");
		}else{
		console.log(joyas);
		var total=0.0;
		joyas.forEach(joya =>{
			 total+=(joya.precio*joya.cantidad);
		});
		console.log(total);
		$("#contenedor").html( Mustache.render(plantillas.carrito,res) );
		
		$("#totalPrice").html(Math.round(total*100)/100 + " &euro;");
		$(".input_cantidad").change(function(){
			alert("mandar al servidor la nueva cantidad, por hacer...");
		});
		$(".enlace_borrar_producto").click(function(){
			alert("borrar producto del carrito, por hacer...");
		});
		$("#realizar_pedido").click(function(){
			checkout_paso_1();
		});
		}
		
	});
	
}//end mostrar_productos_carrito


function logout(){
	$.ajax("ServicioWebUsuarios/logout",{
		success: function(res){
			if(res == "ok"){
				alert("Hasta pronto");
				nombre_login="";
				$("#login").show();
				$("#registrarme").show();
				$("#logout").hide();
				$("#inicio_span_nombre_usuario").html(" (Usuario no identificado)");
				
			}else{
				
			}
		}
	});
}
