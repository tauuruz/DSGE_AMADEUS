<%@ page import="java.util.ArrayList" %>
<%@ page import="Amadeus.MODEL.gestorDLC" <%--
  Created by IntelliJ IDEA.
  User: locua
  Date: 14/01/2023
  Time: 03:04 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/normalize.css">
    <link rel="stylesheet" href="CSS/IU_Gestor_DLC.css">
    <title>DLC</title>
    <%

        //TODO: Revisar lista de DLC
        String juego = request.getParameter("juegoSeleccionado");

        ArrayList<String> listaDLC = new ArrayList<String>();
        listaDLC.add("DLC1");
        listaDLC.add("DLC2");
        listaDLC.add("DLC3");
        listaDLC.add("DLC4");
        listaDLC.add("DLC5");
    %>
</head>
<body>
<header id="titulo">Lista de DLC para <%=juego%></header>
<div>
    <table id="DLCs" class="display">
        <thead id="titulotabla">
        <th style="font-size: 24px">DLC</th>
        </thead>
        <tr>
            <td>
                <table class="tabla" style="border: 1px solid black; border-collapse: collapse;">
                    <% for (String dlc : listaDLC) { %>
                    <tr>
                        <td style="border: 1px solid black; border-collapse: collapse;" onclick="click"><%=dlc%></td>
                    </tr>
                    <% } %>
                </table>
            </td>
            <td>
                <form action="Oyente_Gestor_DLC" method="post">
                    <table class="tabla" style="border: 1px solid black; border-collapse: collapse;">
                        <tr>
                            <td>
                                <label for="fdlc">DLC:</label> <input class="relleno" type="text" name="dlc" id="fdlc"  readonly required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="fprecio">Precio:</label> <input class="relleno" type="number" name="precio" id="fprecio" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href=""> <input id="boton" type="submit" value="Comprar"></a>
                            </td>
                        </tr>
                    </table>
                </form>
        <tr>
            <td>
                <form action="Oyente_Gestor_DLC" method="get">
                    <a href=""><button type="submit" name="opcion" value="1">Volver</button></a>
                </form>
            </td>
        </tr>
        </td>
        </tr>
        <script>
            addEventListener("click", function (event){
                //TODO: Cambiar a la clase DLC
                <% for (String dlc : listaDLC) { %>
                if (event.target.innerHTML === "<%=dlc%>"){
                    document.getElementById("fdlc").value = "<%=dlc%>";
                    document.getElementById("fprecio").value = "10";
                }
                <% } %>
            });
        </script>
    </table>
</div>
</body>
</html>