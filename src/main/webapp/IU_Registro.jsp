<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: locua
  Date: 13/01/2023
  Time: 09:26 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/normalize.css">
    <link rel="stylesheet" href="CSS/IU_Registro.css">
    <title>Registrarse</title>
</head>
<body>
<h4>Has elegido formar parte de AMADEUS</h4>
<h5>Para concluir el registro por favor llene todos lo campos</h5>
<div id="CuadroInicio">
<table id="tabla">
    <tr>
        <td>
            <form action="Oyente_Gestor_Cuenta" method="post">
                <table>
                    <tr>
                        <td><span>Usuario</span></td>
                        <td><input class="input2" type="text" name="usuario" required></td>
                    </tr>
                    <tr>
                        <td><span>Nombre</span></td>
                        <td><input class="input2" type="text" name="nombre" required></td>
                    </tr>
                    <tr>
                        <td><span>Apellido Paterno</span></td>
                        <td><input class="input2" type="text" name="apellidoP" required></td>
                    </tr>
                    <tr>
                        <td><span>Apellido Materno</span></td>
                        <td><input class="input2" type="text" name="apellidoM" required></td>
                    </tr>
                    <tr>
                        <td><span>Direccion</span></td>
                        <td><input class="input2" type="text" name="direccion" required></td>
                    </tr>
                    <tr>
                        <td><span>Telefono</span></td>
                        <td><input class="input2" type="text" name="telefono" required></td>
                    </tr>
                    <tr>
                        <td><span>Correo</span></td>
                        <td><input class="input2" type="text" name="correo" required></td>
                    </tr>
                    <tr>
                        <td><span>Contraseña</span></td>
                        <td><input class="input2" type="password" name="contrasena" required ></td>
                    </tr>
                    <tr>
                        <td><span>Confirmar Contraseña</span></td>
                        <td><input class="input2" type="password" name="contrasena2" required></td>
                    </tr>
                    <% if (request.getAttribute("error") != null) {
                        PrintWriter wr = response.getWriter();
                        wr.println("<tr><td colspan='2' style='color: red'>" + request.getAttribute("error") + "</td></tr>");
                    } %>
                    <tr>
                        <td class="input3">
                            <a href=""><input type="submit" name="Registrarse" value="Registrarse"></a>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="Oyente_Gestor_Cuenta" method="get">
                <a href=""><button type="submit" name="opcion" value="1" formnovalidate>Regresar</button></a>
            </form>
        </td>
    </tr>
</table>
</div>
</body>
</html>
