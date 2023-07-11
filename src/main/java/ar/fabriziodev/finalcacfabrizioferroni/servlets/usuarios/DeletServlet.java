package ar.fabriziodev.finalcacfabrizioferroni.servlets.usuarios;

import ar.fabriziodev.finalcacfabrizioferroni.repository.UserRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "deletUsers" , urlPatterns = "/admin/usuario/eliminar")
public class DeletServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getPathInfo().substring(1);
        UserRepository repo = new UserService();
        HttpSession session = req.getSession();

        try{
            boolean result = repo.delete(Long.parseLong(id));
            if(result){
                session.setAttribute("status", "success");
                session.setAttribute("msg", "Se ha borrado con éxito el usuario");
                resp.sendRedirect("/admin/usuarios");
            }
        } catch (Exception e) {
            session.setAttribute("status", "failed");
            session.setAttribute("msg", e.getMessage());
            resp.sendRedirect("/admin/usuarios");
        }
    }
}
