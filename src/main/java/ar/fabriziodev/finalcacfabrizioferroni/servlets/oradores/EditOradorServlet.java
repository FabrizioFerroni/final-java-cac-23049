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

@WebServlet(name="editOradores", urlPatterns = "/admin/orador/editar")
public class EditOradorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getPathInfo().substring(1);
        OradorRepository repo = new OradorService();
        try{
            Orador orador = repo.getById(Long.parseLong(id));
            req.setAttribute("orador", orador);
        }catch(Exception ex){
            req.setAttribute("error", ex.getMessage());
            System.out.println(ex.getMessage());
        }
        getServletContext().getRequestDispatcher("/admin/oradores/editar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String tema = req.getParameter("tema");
        String id = req.getPathInfo().substring(1);

        if (nombre == "" || apellido == "" || tema == "") {
            req.setAttribute("status", "warning");
            req.setAttribute("msg", "Todos los campos son requeridos");
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("tema", tema);
            getServletContext().getRequestDispatcher("/admin/oradores/editar.jsp").forward(req, resp);
        }

        nombre = toNomProp(nombre);
        apellido = toNomProp(apellido);

        Orador orador = new Orador(Long.parseLong(id), nombre, apellido, tema);

        OradorRepository repo = new OradorService();
        HttpSession session = req.getSession();

        try{
            boolean result = repo.update(Long.parseLong(id), orador);
            if(result){
                session.setAttribute("status", "success");
                session.setAttribute("msg", "Se ha actualizado con éxito el orador");
                resp.sendRedirect("/admin/oradores");
            }else{
                req.setAttribute("status", "failed");
                req.setAttribute("msg", "No se ha podido editar el orador.");
                req.setAttribute("nombre", nombre);
                req.setAttribute("apellido", apellido);
                req.setAttribute("tema", tema);
                getServletContext().getRequestDispatcher("/admin/oradores/editar.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.setAttribute("status", "failed");
            req.setAttribute("msg", ex.getMessage());
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("tema", tema);
            getServletContext().getRequestDispatcher("/admin/oradores/editar.jsp").forward(req, resp);
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
