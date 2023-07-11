package ar.fabriziodev.finalcacfabrizioferroni.servlets.oradores;

import ar.fabriziodev.finalcacfabrizioferroni.models.Orador;
import ar.fabriziodev.finalcacfabrizioferroni.repository.OradorRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.OradorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="readOradores", urlPatterns = "/admin/oradores")
public class ReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OradorRepository repo = new OradorService();
        try{
            ArrayList<Orador> oradores = repo.findAll();
            req.setAttribute("oradores", oradores);
        } catch(Exception ex){
            req.setAttribute("error", ex.getMessage());
        }
        getServletContext().getRequestDispatcher("/admin/oradores/listar.jsp").forward(req, resp);
    }
}
