
package ar.fabriziodev.finalcacfabrizioferroni.servlets;

import ar.fabriziodev.finalcacfabrizioferroni.models.Usuario;
import ar.fabriziodev.finalcacfabrizioferroni.models.dto.UsuarioDto;
import ar.fabriziodev.finalcacfabrizioferroni.repository.AuthRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.AuthService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import ar.fabriziodev.finalcacfabrizioferroni.data.Conexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;


import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "register" , urlPatterns = "/registrarse")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String rutaActual = requestURI.substring(req.getContextPath().length()).replace(".jsp", "");

        req.setAttribute("rutaActual", rutaActual);
        getServletContext().getRequestDispatcher("/auth/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {



        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rol = "user";

        String requestURI = req.getRequestURI();
        String rutaActual = requestURI.substring(req.getContextPath().length()).replace(".jsp", "");
//

        RequestDispatcher dispatcher = null;
        if(nombre == "" || apellido == "" || username == ""|| email == "" || password == ""){
            req.setAttribute("status", "warning");
            req.setAttribute("msg", "Todos los campos son requeridos");
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("email", email);
            req.setAttribute("username", username);
            req.setAttribute("rutaActual", rutaActual);
            getServletContext().getRequestDispatcher("/auth/register.jsp").forward(req, resp);
        }

        if(username.equals("fferroni")){
            rol = "admin";
        }

        String password_hash = BCrypt.hashpw(password, BCrypt.gensalt());

        nombre = toNomProp(nombre);
        apellido = toNomProp(apellido);

        UsuarioDto new_user = new UsuarioDto();

        new_user.setNombre(nombre);
        new_user.setApellido(apellido);
        new_user.setEmail(email);
        new_user.setUsername(username);
        new_user.setPassword(password_hash);
        new_user.setRol(rol);

        AuthRepository repo = new AuthService();
        HttpSession session = req.getSession();

        try{
            boolean result = repo.register(new_user);
            if(result){
                session.setAttribute("status", "success");
                session.setAttribute("msg", "Se ha registrado con éxito el usuario");
//                getServletContext().getRequestDispatcher("/auth/login.jsp").forward(req, resp);
                resp.sendRedirect("/iniciarsesion");
            }else{
                req.setAttribute("rutaActual", rutaActual);
                req.setAttribute("status", "failed");
                req.setAttribute("msg", "No se ha podido crear el usuario.");
                req.setAttribute("nombre", nombre);
                req.setAttribute("apellido", apellido);
                req.setAttribute("email", email);
                req.setAttribute("username", username);
//                req.setAttribute("rutaActual", rutaActual);
                getServletContext().getRequestDispatcher("/auth/register.jsp").forward(req, resp);
            }
        } catch (Exception ex){
            req.setAttribute("rutaActual", rutaActual);
            req.setAttribute("status", "failed");
            req.setAttribute("msg", ex.getMessage());
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("email", email);
            req.setAttribute("username", username);

            getServletContext().getRequestDispatcher("/auth/register.jsp").forward(req, resp);
            System.out.println(ex.getMessage());
        }

    }


    public static String toNomProp(String element) {
        StringBuilder result = new StringBuilder();
        String[] palabras = element.split(" ");

        for (String palabra : palabras) {
            result.append(Character.toUpperCase(palabra.charAt(0)))
                    .append(palabra.substring(1))
                    .append(" ");
        }

        return result.toString().trim();
    }

}
