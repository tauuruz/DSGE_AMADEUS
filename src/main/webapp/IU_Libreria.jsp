<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="Amadeus.MODEL.libreria" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: locua
  Date: 13/01/2023
  Time: 10:56 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Libreria</title>
  <link rel="stylesheet" href="CSS/normalize.css">
  <link rel="stylesheet" href="CSS/IU_Libreria.css">
  <%
    PrintWriter wr = response.getWriter();
    //TODO: Cambiar a clase Videojuego
    libreria lib = new libreria();
    List<String> juegos = lib.mostrarLibreria(request.getSession().getAttribute("usuario").toString());
    String juegoSeleccionado = null;
  %>
</head>
<body>
    <form action="Oyente_Gestor_videojuegos" method="get">
      <h3 style="display: inline; padding-right: 200px;">Libreria</h3>
      <a href=""><button type="submit" name="opcion" value="3">Hazte Premium</button></a>
    </form>
    <table id="Videojuegos" class="display">
      <thead>
        <th>Tus Juegos</th>
      </thead>
      <tr>
        <td>
          <table class="tabla2">
            <% for (String juego : juegos) { %>
              <tr>
                <td style="border: 1px solid black; border-collapse: collapse;" onclick="click"><%=juego%></td>
              </tr>
            <% } %>
          </table>
        </td>
        <td class="tabla2">
          Juego: <input type="text" id="juego" name="juego" value="" readonly>
        </td>
        <!--Mostrar informacion del videojuego seleccionado-->
        <script>
          addEventListener("click", function (event) {
            //Mostrar informacion del videojuego seleccionado
            //TODO: Cambiar a clase Videojuego y mostrar su informacion
            <% for (String juego : juegos) { %>
              if (event.target.innerHTML == "<%=juego%>") {
                document.getElementById("juego").value = "<%=juego%>";
                document.getElementById("juegoSeleccionado").value = "<%=juego%>";
              }
            <% } %>
          });
        </script>
      </tr>
      <tr>
        <td>
          <form action="Oyente_Gestor_videojuegos" method="get">
            <a href=""><button type="submit" name="opcion" value="1">Tienda</button></a>
            <a href=""><button type="submit" name="opcion" value="2">Noticias</button></a>
            <a href=""><button type="submit" name="opcion" value="4">Ver perfil</button></a>
            <a href=""><input type="hidden" id="juegoSeleccionado" name="juegoSeleccionado" value=""></a>
            <a href=""><button type="submit" name="opcion" value="7">Ver DLC</button></a>
          </form>
        </td>
      </tr>
    </table>
</body>
</html>