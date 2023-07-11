package ar.fabriziodev.finalcacfabrizioferroni.servlets.oradores;

import ar.fabriziodev.finalcacfabrizioferroni.models.Orador;
import ar.fabriziodev.finalcacfabrizioferroni.repository.OradorRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.OradorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="deletOradores", urlPatterns = "/admin/orador/eliminar")
public class DeletOradorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getPathInfo().substring(1);
        OradorRepository repo = new OradorService();
        HttpSession session = req.getSession();
        try{
            boolean result = repo.delete(Long.parseLong(id));
            if(result){
                session.setAttribute("status", "success");
                session.setAttribute("msg", "Se ha borrado con éxito el orador");
                resp.sendRedirect("/admin/oradores");
            } else{
                session.setAttribute("status", "failed");
                session.setAttribute("msg", "No se ha borrado el orador");
                resp.sendRedirect("/admin/oradores");
            }
        }catch(Exception ex){
            session.setAttribute("status", "failed");
            session.setAttribute("msg", ex.getMessage());
            resp.sendRedirect("/admin/oradores");
            System.out.println(ex.getMessage());
        }
    }
}
