package Amadeus.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "Oyente_Gestor_DLC", value = "/Oyente_Gestor_DLC")
public class Oyente_Gestor_DLC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Regresar a la pagina de la libreria
        RequestDispatcher dispatcher = req.getRequestDispatcher("IU_Libreria.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("juego", null);
        String dlc = req.getParameter("dlc");
        req.setAttribute("dlc", dlc);
        RequestDispatcher dispatcher = req.getRequestDispatcher("IU_Gestor_Pagos.jsp");
        dispatcher.forward(req, resp);
    }
}
