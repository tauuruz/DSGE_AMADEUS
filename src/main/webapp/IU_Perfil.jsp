<%@ page import="Amadeus.MODEL.usuario" %>
<%@ page import="Amadeus.MODEL.gestorCuenta" %><%--
  Created by IntelliJ IDEA.
  User: locua
  Date: 13/01/2023
  Time: 10:03 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/normalize.css">
    <link rel="stylesheet" href="CSS/IU_Perfil.css">
    <title>Informacion de la cuenta</title>
</head>
<body>
<h4>Informacion de la cuenta:</h4>
<%
    gestorCuenta gestor = new gestorCuenta();
    usuario user = gestor.visualizarCuenta(request.getSession().getAttribute("usuario").toString());
%>
<div id="CuadroInicio">
<table id="tabla">
    <tr>
        <td>
            <form action="Oyente_Gestor_Cuenta" method="post">
                <table>
                    <tr>
                        <td> <span>Usuario</span></td>
                        <td><input class="input2" type="text" name="usuario" value="<%=user.getUsuario()%>" required readonly></td>
                    </tr>
                    <tr>
                        <td> <span>Nombre</span> </td>
                        <td><input class="input2" type="text" name="nombre" value="<%=user.getNombre()%>" required readonly></td>
                    </tr>
                    <tr>
                        <td> <span>Apellido Paterno</span> </td>
                        <td><input class="input2" type="text" name="apellidoP" value="<%=user.getPaterno()%>" required readonly></td>
                    </tr>
                    <tr>
                        <td> <span>Apellido Materno</span> </td>
                        <td><input class="input2" type="text" name="apellidoM" value="<%=user.getMaterno()%>" required readonly></td>
                    </tr>
                    <tr>
                        <td> <span>Direccion</span> </td>
                        <td><input class="input2" type="text" name="direccion" value="<%=user.getDireccion()%>" required readonly></td>
                    </tr>
                    <tr>
                        <td> <span>Telefono</span> </td>
                        <td><input class="input2" type="text" name="telefono" value="<%=user.getTelefono()%>" required readonly></td>
                    </tr>
                    <tr>
                        <td> <span>Correo</span> </td>
                        <td><input class="input2" type="text" name="correo" value="<%=user.getCorreo()%>" required readonly></td>
                    </tr>
                    <tr>
                        <td> <span>Contraseña</span> </td>
                        <td><input class="input2" type="password" name="contrasena" required></td>
                    </tr>
                    <tr>
                        <td> <span>Confirmar Contraseña</span> </td>
                        <td><input class="input2"type="password" name="contrasena2" required></td>
                    </tr>
                    <tr>
                        <td class="input3">
                            <a href=""><input  type="submit" name="Cambiar" value="Cambiar"></a>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="Oyente_Gestor_Cuenta" method="get">
                <a href=""><button type="submit" name="opcion" value="2" formnovalidate>Regresar</button></a>
            </form>
        </td>
    </tr>
</table>
</div>
</body>
</html>
