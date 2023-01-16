package Amadeus.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import Amadeus.MODEL.gestorCuenta;

@WebServlet(name = "Oyente_IU_Principal", value = "/Oyente_IU_Principal")
public class Oyente_IU_Principal extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            RequestDispatcher dispatcher;
            //Determinar a que pagina se va a redireccionar
            switch (request.getParameter("opcion")) {
                case "1":
                    //Redireccionar a la pagina de registro
                    dispatcher = request.getRequestDispatcher("IU_Registro.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "2":
                    //Redireccionar a la tienda
                    dispatcher = request.getRequestDispatcher("IU_Tienda.jsp");
                    dispatcher.forward(request, response);
                    break;
                default:
                    //Redireccionar a la pagina de inicio
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            gestorCuenta gestor = new gestorCuenta();
            if(gestor.logIn(request.getParameter("usuario"), request.getParameter("password")) == 1 ){
                request.getSession().setAttribute("usuario", request.getParameter("usuario"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("IU_Libreria.jsp");
                dispatcher.forward(request, response);
            } else if (gestor.logInDev(request.getParameter("usuario"), request.getParameter("password")) == 1){
                request.getSession().setAttribute("usuario", request.getParameter("usuario"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("IU_Libreria.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
