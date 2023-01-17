<%@ page import="java.util.ArrayList" %>
<%@ page import="Amadeus.MODEL.gestorNoticias" %>
<%@ page import="Amadeus.MODEL.noticia"%>
<%@ page import="java.util.List" %> <%--
  Created by IntelliJ IDEA.
  User: locua
  Date: 14/01/2023
  Time: 01:24 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Noticias</title>
    <link rel="stylesheet" href="CSS/normalize.css">
    <link rel="stylesheet" href="CSS/IU_Gestor_Noticias.css">
  <%
    gestorNoticias gestor = new gestorNoticias();
    List<noticia> noticias = gestor.visualizarNoticias();
  %>
</head>
<body>
	
		<div id="CuadroInicio">
  			<table id="noticias" class="display">
    			<tbody>
      				<%
        				for (noticia noticia : noticias) {
      				%>
      			<tr>
        			<td style="font-size: 35px"><%= noticia.getTitulo() %></td>
      			</tr>
      			<tr>
        			<td style="font-size: 25px"><%=noticia.getFecha()%></td>
      			</tr>
      			<tr>
        			<td>
          				<textarea style="width: 100%; height: 200px; resize: none; font-size: 20px" readonly><%=noticia.getNoticia()%>></textarea>
        			</td>
      			</tr>
      				<%
        				}
      				%>
      			</tbody>
     		</table>
  		</div>
  		<div id="Cuadro">
            <form action="Oyente_Gestor_Noticias" method="get">
              <a><button type="submit" name="opcion" value="1">Regresar</button></a>
            </form>
   		</div>
 
</body>
</html>
