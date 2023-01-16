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
    <title>Registrarse</title>
</head>
<body>
<h4>Has elegido formar parte de AMADEUS</h4>
<h5>Para concluir el registro por favor llene todos lo campos</h5>
<table>
    <tr>
        <td>
            <form action="Oyente_Gestor_Cuenta" method="post">
                <table>
                    <tr>
                        <td>Usuario</td>
                        <td><input type="text" name="usuario" required></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombre" required></td>
                    </tr>
                    <tr>
                        <td>Apellido Paterno</td>
                        <td><input type="text" name="apellidoP" required></td>
                    </tr>
                    <tr>
                        <td>Apellido Materno</td>
                        <td><input type="text" name="apellidoM" required></td>
                    </tr>
                    <tr>
                        <td>Direccion</td>
                        <td><input type="text" name="direccion" required></td>
                    </tr>
                    <tr>
                        <td>Telefono</td>
                        <td><input type="text" name="telefono" required></td>
                    </tr>
                    <tr>
                        <td>Correo</td>
                        <td><input type="text" name="correo" required></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                        <td><input type="password" name="contrasena" required ></td>
                    </tr>
                    <tr>
                        <td>Confirmar Contraseña</td>
                        <td><input type="password" name="contrasena2" required></td>
                    </tr>
                    <% if (request.getAttribute("error") != null) {
                        PrintWriter wr = response.getWriter();
                        wr.println("<tr><td colspan='2' style='color: red'>" + request.getAttribute("error") + "</td></tr>");
                    } %>
                    <tr>
                        <td><input type="submit" name="Registrarse" value="Registrarse"></td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="Oyente_Gestor_Cuenta" method="get">
                <button type="submit" name="opcion" value="1" formnovalidate>Regresar</button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
