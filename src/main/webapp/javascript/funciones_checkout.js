//funciones de js para los pasos del checkout
function checkout_paso_1(){
	//datos de envio del pedido
	$("#contenedor").html(plantillas.checkout_1);
	$("#aceptar_paso_1").click(function(){
		let nombre = $("#campo_nombre").val();
		let direccion = $("#campo_direccion").val();
		let cp=$("#campo_cp").val();
		let movil=$("#campo_movil").val();
		let provincia = $("#campo_provincia").val();
		
		$.post("ServicioWebPedidos/paso1",
			{
				nombre: nombre,
				direccion: direccion,
				cp: cp,
				movil: movil,
				provincia: provincia	
			}
		).done(function(res){
			if(res == "ok"){
				//mostrar la plantilla del paso 2
				checkout_paso_2();
			}else{
				alert(res);
			}
		});	//end done
	});//end click	
}//end checkout_paso_1

function checkout_paso_2(){
	//datos de envio del pedido
	$("#contenedor").html(plantillas.checkout_2);
	$("#aceptar_paso_2").click(function(){
		let titularTarjeta =$("#titular_tarjeta").val();
        let numeroTarjeta= $("#numero_tarjeta").val();
	
		 $.post("ServicioWebPedidos/paso2",
		{
			titular: titularTarjeta,
			numero: numeroTarjeta
			}
		).done(function(res){
			if(res == "ok"){
			
				checkout_paso_3();
			}else{
				alert(res);
			}
		});	//end done
	});//end click	
}


function checkout_paso_3(){
	$("#contenedor").html(plantillas.checkout_3);
	$("#aceptar_paso_3").click(function(){
		 let informacion =$("#detalle").val();
		$.post("ServicioWebPedidos/paso3",{
			detalle:informacion
			
		}).done(function(res){
			
			if( res.substring(0,2) == "ok" ){
				let json = JSON.parse(res.substring(3,res.length));
				let html = Mustache.render(plantillas.confirmar_pedido,json);
				res=JSON.parse(res.substring(3,res.length));
				let joyas=res.joyas;
				let precioT=0.0;
				$("#contenedor").html(html);
				$("#boton_confirmar_pedido").click(checkout_confirmar);
				joyas.forEach(joya=>{
					precioT +=(joya.precio*joya.cantidad);
					
				});
					$("#totalPrecio").html(precioT +  "€");
				
			}
		});//done 
	});//end click aceptar_paso_2
}//end checkout_paso_2

function checkout_confirmar(){
	$.ajax("ServicioWebPedidos/confirmarPedido",{
		
		success : function(res){
		
			alert(res);
			
			mostrar_productos();
			
		
		
			
		}
	});
}//end checkout_confirmar