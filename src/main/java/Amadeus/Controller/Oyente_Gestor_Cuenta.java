package Amadeus.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import Amadeus.MODEL.gestorCuenta;

import static java.lang.Boolean.*;

@WebServlet(name = "Oyente_Gestor_Cuenta", value = "/Oyente_Gestor_Cuenta")
public class Oyente_Gestor_Cuenta extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            RequestDispatcher dispatcher;
            //Determinar a que pagina se va a redireccionar
            switch (request.getParameter("opcion")){
                case "1":
                    //Redireccionar a la pagina principal
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "2":
                    //Redireccionar a la libreria
                    dispatcher = request.getRequestDispatcher("IU_Libreria.jsp");
                    dispatcher.forward(request, response);
                default:
                    //Redireccionar al formulario de registro
                    dispatcher = request.getRequestDispatcher("IU_Registro.jsp");
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
            RequestDispatcher dispatcher;
            if(request.getParameter("Registrarse") != null){
                String usuario = request.getParameter("usuario");
                String nombre = request.getParameter("nombre");
                String apellidoP = request.getParameter("apellidoP");
                String apellidoM = request.getParameter("apellidoM");
                String direccion = request.getParameter("direccion");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("correo");
                String contrasena = request.getParameter("contrasena");
                String contrasena2 = request.getParameter("contrasena2");
                System.out.println("c1: " + contrasena + " c2: " + contrasena2);
                //Si las contraseñas coinciden agregar al usuario a la base de datos y redireccionar a la pagina principal
                if(contrasena.equals(contrasena2)){
                    gestor.registrarUsuario(usuario, nombre, apellidoP, apellidoM, direccion, telefono, correo, contrasena, FALSE);
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                }
                //Si las contraseñas no coinciden redireccionar al formulario de registro y mostrar un mensaje de error
                else{
                    request.setAttribute("error", "Las contraseñas no coinciden, intentalo de nuevo");
                    dispatcher = request.getRequestDispatcher("IU_Registro.jsp");
                    dispatcher.forward(request, response);
                }
            }
            //Cambiar contraseña
            if(request.getParameter("Cambiar") != null){
                String contrasena = request.getParameter("contrasena");
                String contrasena2 = request.getParameter("contrasena2");
                String usuario = request.getParameter("usuario");
                //Si las contraseñas coinciden agregar al usuario a la base de datos y redireccionar a la pagina principal
                if(contrasena.equals(contrasena2)){
                    gestor.cambiarPssw(gestor.visualizarCuenta(usuario).getId_usuario(), contrasena);
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                }
                //Si las contraseñas no coinciden redireccionar al formulario de registro y mostrar un mensaje de error
                else{
                    request.setAttribute("error", "Las contraseñas no coinciden, intentalo de nuevo");
                    dispatcher = request.getRequestDispatcher("IU_Perfil.jsp");
                    dispatcher.forward(request, response);
                }
                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }else {

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
