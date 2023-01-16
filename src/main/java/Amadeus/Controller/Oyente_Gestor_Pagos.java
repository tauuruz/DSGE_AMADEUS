package Amadeus.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import Amadeus.MODEL.gestorPagos;
import Amadeus.MODEL.videojuego;

@WebServlet(name = "Oyente_Gestor_Pagos", value = "/Oyente_Gestor_Pagos")
public class Oyente_Gestor_Pagos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("IU_Tienda.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Verificar la informacion de pago
        //Si la informacion es correcta alertar al usuario y redireccionar a la pagina de la tienda
        //Si la informacion es incorrecta alertar al usuario
        gestorPagos gestorPagos = new gestorPagos();

        String numeroTarjeta = req.getParameter("numeroTarjeta");
        String nombreTitular = req.getParameter("nombreTitular");
        String fechaVencimiento = req.getParameter("fechaVencimiento");
        String codigoSeguridad = req.getParameter("cvv");
        String precio = req.getParameter("precio");
        videojuego juego = (videojuego) req.getSession().getAttribute("juegoSeleccionado");
        //Verificacion
        gestorPagos.comprarJuego(juego, req.getSession().getAttribute("usuario").toString());

        PrintWriter out = resp.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Pago realizado con exito Juego: "+juego.getNombre()+" Precio: "+precio+"');");
        out.println("location='IU_Tienda.jsp';");
        out.println("</script>");
    }
}
