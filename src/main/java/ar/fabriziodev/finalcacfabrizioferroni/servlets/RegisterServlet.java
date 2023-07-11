
package ar.fabriziodev.finalcacfabrizioferroni.servlets;

import ar.fabriziodev.finalcacfabrizioferroni.models.Usuario;
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

import org.mindrot.jbcrypt.BCrypt;


import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "register" , urlPatterns = "/registrarse")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/auth/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        LocalDateTime fechaCreacion = LocalDateTime.now();
//

        RequestDispatcher dispatcher = null;
        if(nombre == "" || apellido == "" || username == "" || password == ""){
            req.setAttribute("status", "warning");
            req.setAttribute("msg", "Todos los campos son requeridos");
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/auth/register.jsp").forward(req, resp);
        }

        String password_hash = BCrypt.hashpw(password, BCrypt.gensalt());

        Usuario new_user = new Usuario(nombre, apellido, username, password_hash, fechaCreacion);

        AuthRepository repo = new AuthService();

        try{
            boolean result = repo.register(new_user);
            if(result){
                req.setAttribute("status", "success");
                req.setAttribute("msg", "Se ha registrado con éxito el usuario");
                getServletContext().getRequestDispatcher("/auth/login.jsp").forward(req, resp);
            }else{
                req.setAttribute("status", "failed");
                req.setAttribute("msg", "No se ha podido crear el usuario.");
                req.setAttribute("nombre", nombre);
                req.setAttribute("apellido", apellido);
                req.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/auth/register.jsp").forward(req, resp);
            }
        } catch (Exception ex){
            req.setAttribute("status", "failed");
            req.setAttribute("msg", ex.getMessage());
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/auth/register.jsp").forward(req, resp);
            System.out.println(ex.getMessage());
        }

    }


}
