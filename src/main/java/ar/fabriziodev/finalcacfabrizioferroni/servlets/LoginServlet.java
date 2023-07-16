package ar.fabriziodev.finalcacfabrizioferroni.servlets;

import ar.fabriziodev.finalcacfabrizioferroni.models.Usuario;
import ar.fabriziodev.finalcacfabrizioferroni.repository.AuthRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.AuthService;
import jakarta.servlet.annotation.WebServlet;
import ar.fabriziodev.finalcacfabrizioferroni.data.Conexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "login" , urlPatterns = "/iniciarsesion")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String rutaActual = requestURI.substring(req.getContextPath().length()).replace(".jsp", "");

        req.setAttribute("rutaActual", rutaActual);
            getServletContext().getRequestDispatcher("/auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AuthRepository repo = new AuthService();
        HttpSession session = req.getSession();
        String requestURI = req.getRequestURI();
        String rutaActual = requestURI.substring(req.getContextPath().length()).replace(".jsp", "");

        try {

            Object resultadoLogin = repo.login(username, password);

            // Verificación del tipo de resultado
            if (resultadoLogin instanceof Usuario) {
                Usuario usuario = (Usuario) resultadoLogin;

                // Acceder a los campos individuales del objeto Usuario
                Long id = usuario.getId();
                String nombre = usuario.getNombre();
                String apellido = usuario.getApellido();
                String email = usuario.getEmail();
                String username_bd = usuario.getUsername();
                String rol = usuario.getRol();

                session.setAttribute("id", id);
                session.setAttribute("nombre", nombre);
                session.setAttribute("apellido", apellido);
                session.setAttribute("email", email);
                session.setAttribute("usuario", username_bd);
                session.setAttribute("rol", rol);
                session.setAttribute("status", "success");
                session.setAttribute("msg", "Te has logueado con éxito al sistema");
//                getServletContext().getRequestDispatcher("/dashboard/index.jsp").forward(req, resp);
                if(usuario.getRol().equals("admin")){
                    resp.sendRedirect(req.getContextPath() + "/admin/tablero");
                } else if(usuario.getRol().equals("user")){
                    resp.sendRedirect(req.getContextPath() + "/tickets");
                }


            } else if (resultadoLogin instanceof String) {
                String mensajeError = (String) resultadoLogin;
                req.setAttribute("rutaActual", rutaActual);
                req.setAttribute("status", "warning");
                req.setAttribute("msg", mensajeError);
                req.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/auth/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("rutaActual", rutaActual);
            req.setAttribute("status", "failed");
            req.setAttribute("msg", e.getMessage());
            getServletContext().getRequestDispatcher("/auth/login.jsp").forward(req, resp);
            System.out.println(e.getMessage());
        }
    }
}
