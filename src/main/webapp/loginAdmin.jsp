<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <link rel="stylesheet" href="css/formulariosAdmin.css">
</head>
<body>

<div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">Identifícate</h2>

  <form class="login-container" method="post" action="admin/">
    <p><input type="password" placeholder="Contraseña" name="pass" required></p>
     <p><input type="submit" value="Aceptar" class="boton"></p>
  </form>
</div>


</body>
</html>