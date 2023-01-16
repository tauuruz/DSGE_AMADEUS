package Amadeus.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "Oyente_Gestor_Noticias", value = "/Oyente_Gestor_Noticias")
public class Oyente_Gestor_Noticias extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher;
            //Determinar a que pagina se va a redireccionar
            switch (request.getParameter("opcion")) {
                case "1":
                    //Redireccionar a la libreria
                    dispatcher = request.getRequestDispatcher("IU_Libreria.jsp");
                    dispatcher.forward(request, response);
                    break;
                default:
                    //Redireccionar a la pagina de inicio
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
