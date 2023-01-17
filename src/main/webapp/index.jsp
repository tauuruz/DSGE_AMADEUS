<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="CSS/normalize.css">
    <link rel="stylesheet" href="CSS/index.css">
    <title>Amadeus</title>
</head>

<body>
<header>
	<h1>Bienvenido</h1>
</header>
<div id="CuadroInicio">


    <!--Logo-->
    <img src="images/logo.jpg" alt="logo" id="logo">
    <!--Formulario de acceso-->
    <!--Formulario en tabla-->



    <form action="Oyente_IU_Principal" method="post">
        <div class="formulario">
            <label for="fusuario">Usuario:</label>
            <input idtype="text" name="usuario" value="" required id="fusuario">
        </div>
        <div class="formulario">
            <label for="fpassword">Contraseña:</label>
            <input type="password" name="password" value="" required id="fpassword">
        </div>
        <a href=""> <input type="submit" value="Entrar" id="enviar">  </a>
    </form>
    <h5>¿No tienes cuenta?</h5>
    <form action="Oyente_IU_Principal" method="get">
        <a href=""><button class="boton" type="submit" name="opcion" value="1">Registrate</button></a>
        <a href=""><button class="boton" type="submit" name="opcion" value="2">Ver tienda</button></a>
    </form>

</div>
</body>

</html>