function cargarEventos(){
	//con jquery digo que va a pasar cuando se haga click en un enlace
	$("#inicio").click(function(){
		$("#contenedor").html(plantillas.portada);
		
		
	});
	$("#verproductosInicio").click(function(){
		mostrar_productos();
	});
	
	$("#verproductos").click(function() {
		mostrar_productos();
	});
    
	$("#carrito").click(function(){
		mostrar_productos_carrito();
	});
	
	$("#cuenta").click(function(){
		$("#contenedor").html(plantillas.cuenta);
		
			if(typeof(Cookies.get("emailLogin")) != "undefined") {
				$("#emailLogin").val(Cookies.get("emailLogin"));
			}
			 if(typeof(Cookies.get("contrasenaLogin")) != "undefined") {
			
			$("#contrasenaLogin").val(Cookies.get("contrasenaLogin"));
		  }
			$("#form_login").submit(function(e){
			e.preventDefault();
			identificar_usuario();
			
		});
		
		
	 $("#form_registro_usuario").submit(function(e){
			e.preventDefault();//se cancela el envio de form de forma tradicional
			let formulario = this;
			let formData = new FormData(formulario);
			
			if( !validarNombre(formData.get("nombre")) || 
			    !validarApellidos(formData.get("apellidos")) || 
			    !validarEdad(formData.get("edad")) ||
			    !validarEmail(formData.get("email")) || 
			    !validarPass(formData.get("contrasena"))) {
		
				return false;
			}
			
			$.ajax("ServicioWebUsuarios/registrarUsuario",{
				type: "POST",
				data: formData,
				cache: false,
				contentType: false,
				processData: false,
				success: function(res){
					if(res == "ok"){
						alert("ya puedes identificarte con tus datos");
						
					}else{
						alert(res);	
					}
				}
			});							
		});
       
		
	});

	
	

	$("#logout").click(function(e){
		logout();		
	});//end click logout
	
}//cargar eventos
