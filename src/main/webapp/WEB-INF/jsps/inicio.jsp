<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>


<link href="css/estilo.css" rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
 <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">


        

  
</head>
 <style>
 	input[type=number]{ 
 	    margin:10px;		
 		width:3em  	
 	} 
</style>
<body id="main-box">

<div class="divTituyLeng">
<h3 class="tituloBienvenida"><spring:message code="inicio.bienvenida"/><span id="inicio_span_nombre_usuario" class="spanUsu"> <spring:message code="inicio.inicio_span_nombre_usuario"/></span></h3>
<div class="idiomas">
	<a href="?lang=es"><img src="assets/espana.png"/></a>
	<a href="?lang=en"><img src="assets/united-kingdom.png"/></a>
	<a href="?lang=ro"><img src="assets/rumania.png"/></a>
	
	</div> 
</div>


<nav class="navbar navbar-expand-lg navbar-dark" style="background-color:#ee9f9f; opacity:.8;">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#" id="inicio"><spring:message code="inicio.inicio"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link "  href="#" id="verproductosInicio"><spring:message code="inicio.productos"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="carrito"><spring:message code="inicio.carrito"/></a>
                </li>
                
                <li class="nav-item ">
                    <a class="nav-link " href="admin/" id="admin"><spring:message code="inicio.administracion"/></a>
     
                </li>
                 <li class="nav-item">
                   <a class="nav-link " href="#" id="cuenta"><spring:message code="inicio.cuenta"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " id="logout"><spring:message code="inicio.salir"/></a>
                </li>
        
            </ul>
            
        </div>
         <form class="d-flex">
                <input id="buscador_titulo" class="form-control me-2" type="text" placeholder="Buscar" aria-label="Search">
                <i class="glyphicon glyphicon-search" style="width: 50px; margin:10px;"></i>
            </form>
    </div>
</nav>




 

<div id="contenedor" class="conte">

</div>
<div class="feature">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-lg-3 col-md-6 feature-col">
                        <div class="feature-content">
                            <img class="iconosFinal" src="./assets/pagoseguro.png"/>
                            <h2 class="tituloFinal">PAGO SEGURO</h2>
                            <p>
                                Compra y pago 100% seguros
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 feature-col">
                        <div class="feature-content">
                           <img class="iconosFinal" src="./assets/devolucion.png"/>
                            <h2 class="tituloFinal">DEVOLUCION GRATUITA</h2>
                            <p>
                                14 días para devolver tu pedido
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 feature-col">
                        <div class="feature-content">
                            <img class="iconosFinal" src="./assets/caja.png"/>
                            <h2 class="tituloFinal"> Entrega en 24 HORAS</h2>
                            <p>
                                Entrega en días laborales
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 feature-col">
                        <div class="feature-content">
                           <img class="iconosFinal" src="./assets/garantia.png"/>
                            <h2 class="tituloFinal">GARANTÍA 3 AÑOS</h2>
                            <p>
                                En todos los productos
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
         <!-- Footer Start -->
        <div class="footer">
            <div class="container-fluido">
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Contacto</h2>
                            <div class="contact-info">
                                <p><i class="fa fa-map-marker"></i>123 E Store, Los Angeles, USA</p>
                                <p><i class="fa fa-envelope"></i>email@example.com</p>
                                <p><i class="fa fa-phone"></i>+123-456-7890</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Síguenos</h2>
                            <div class="contact-info">
                                <div class="social">
                                    <a href=""><i class="fab fa-twitter"></i></a>
                                    <a href=""><i class="fab fa-facebook-f"></i></a>
                                    <a href=""><i class="fab fa-linkedin-in"></i></a>
                                    <a href=""><i class="fab fa-instagram"></i></a>
                                    <a href=""><i class="fab fa-youtube"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Info</h2>
                            <ul>
                                <li><a href="#">Sobre nosotros</a></li>
                                <li><a href="#">Política de Privacidad</a></li>
                                <li><a href="#">Términos y condiciones</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Info Compra</h2>
                            <ul>
                                <li><a href="#">Política de pago</a></li>
                                <li><a href="#">Política de envío</a></li>
                                <li><a href="#">Política de devolución</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                
                <div class="row payment align-items-center">
                    <div class="col-md-6">
                        <div class="payment-method">
                            <h2>Aceptamos:</h2>
                            <img src="assets/payment-method.png" alt="Payment Method" />
                        </div>
                    </div>
                   
                </div>
            </div>
        </div>
        <!-- Footer End -->

</body>
<script type="text/javascript" src="librerias_js/jquery.js"></script>
<script type="text/javascript" src="librerias_js/mustache.js" ></script>
<script type="text/javascript" src="librerias_js/js.cookie.min.js" ></script>
<script type="text/javascript" src="javascript/cargar_plantillas.js"></script>
<script type="text/javascript" src="javascript/validaciones.js"></script>
<script type="text/javascript" src="javascript/cargar_eventos.js"></script>
<script type="text/javascript" src="javascript/funciones.js"></script>
<script type="text/javascript" src="javascript/globales.js"></script>
<script type="text/javascript" src="javascript/funciones_checkout.js"></script>


<script type="text/javascript">
	idioma_actual= "<spring:message code="codigo.idioma"/>";
    carga_archivos_plantillas(idioma_actual);
</script>
</html>