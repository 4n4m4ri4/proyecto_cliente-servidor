var plantillas = {};


function carga_archivos_plantillas(idioma){
	$.get("ServicioWebPlantillas",function(res){
		
		var arr = JSON.parse(res);
		for(i in arr){
			var nombre_archivo = arr[i].split(".")[0];
			plantillas[nombre_archivo] = "";
		}
		console.log("contenido del objeto plantillas");
		console.log(plantillas);
		cargarPlantillas(idioma);
	});
}
function cargarPlantillas(idioma){
	var carpeta="plantillas";
	if(idioma == "en"){
		carpeta="plantillas_en";
	}
	if(idioma == "ro"){
		carpeta="plantillas_ro";
	}
	//funcional:
	for (i in plantillas){
		var plantilla_a_cargar = carpeta + "/" + i + ".html";
		//alert("descargando plantilla: " + plantilla_a_cargar);
	
		$.ajax(plantilla_a_cargar,
				{
					parametro : i,
					success: function(res ){
						plantillas[this.parametro] = res;
						//alert("cargado en " + this.parametro + " : " + res);
					}//end function
				}
		);//end get
	}//end for
	$("#contenedor").html("cargando...");
	//la siguiente linea ejecuta la funcion comprobarPlantillas una y otra vez 
	//cada segundo
	intervalo = setInterval(comprobarPlantillas,1000);
}//end cargarPlantillas

function comprobarPlantillas(){
	var listo = true;
	for(i in plantillas){
		if ( plantillas[i] == "" ){
			listo = false;
		}
	}//end for
	if( listo ){
		$("#contenedor").html(plantillas.portada);
			cargarEventos();
		//parar el interval, para que deje de ejecutar comprobarPlantillas cada seg
		clearInterval(intervalo);
	}//end if
}//end comprobarPlantillas