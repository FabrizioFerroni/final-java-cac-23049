package ar.fabriziodev.finalcacfabrizioferroni.servlets.usuarios;

import ar.fabriziodev.finalcacfabrizioferroni.models.Usuario;
import ar.fabriziodev.finalcacfabrizioferroni.repository.UserRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "readUsers" , urlPatterns = "/admin/usuarios")
public class ReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String rutaActual = requestURI.substring(req.getContextPath().length()).replace(".jsp", "");

        req.setAttribute("rutaActual", rutaActual);
        UserRepository repo = new UserService();
        try{
            ArrayList<Usuario> users = repo.findAll();
            req.setAttribute("users", users);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
        }
        getServletContext().getRequestDispatcher("/admin/usuarios/listar.jsp").forward(req, resp);
    }
}
