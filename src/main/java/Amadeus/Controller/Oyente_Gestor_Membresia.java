package Amadeus.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "Oyente_Gestor_Membresia", value = "/Oyente_Gestor_Membresia")
public class Oyente_Gestor_Membresia extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("IU_Libreria.jsp");
        dispatcher.forward(req, resp);
    }
}
