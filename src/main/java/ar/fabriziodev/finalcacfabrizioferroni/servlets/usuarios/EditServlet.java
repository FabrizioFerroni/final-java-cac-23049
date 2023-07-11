package ar.fabriziodev.finalcacfabrizioferroni.servlets.usuarios;

import ar.fabriziodev.finalcacfabrizioferroni.models.Usuario;
import ar.fabriziodev.finalcacfabrizioferroni.repository.UserRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "editUser" , urlPatterns = "/admin/usuario/editar")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getPathInfo().substring(1);
        UserRepository repo = new UserService();
        try{
            Usuario user = repo.getById(Long.parseLong(id));
            req.setAttribute("user", user);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            System.out.println(e.getMessage());
        }
        getServletContext().getRequestDispatcher("/admin/usuarios/editar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String username = req.getParameter("username");
        String id = req.getPathInfo().substring(1);
//

        RequestDispatcher dispatcher = null;
        if(nombre == "" || apellido == "" || username == ""){
            req.setAttribute("status", "warning");
            req.setAttribute("msg", "Todos los campos son requeridos");
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/admin/usuarios/editar.jsp").forward(req, resp);
        }

        nombre = toNomProp(nombre);
        apellido = toNomProp(apellido);

        Usuario edit_user = new Usuario(Long.parseLong(id), nombre, apellido, username);

        UserRepository repo = new UserService();
        HttpSession session = req.getSession();

        try{
            boolean result = repo.update(Long.parseLong(id), edit_user);
            if(result){
                session.setAttribute("status", "success");
                session.setAttribute("msg", "Se ha actualizado con éxito el usuario");
                resp.sendRedirect("/admin/usuarios");
            }else{
                req.setAttribute("status", "failed");
                req.setAttribute("msg", "No se ha podido editar el usuario.");
                req.setAttribute("nombre", nombre);
                req.setAttribute("apellido", apellido);
                req.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/admin/usuarios/editar.jsp").forward(req, resp);
            }
        } catch (Exception ex){
            req.setAttribute("status", "failed");
            req.setAttribute("msg", ex.getMessage());
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/admin/usuarios/editar.jsp").forward(req, resp);
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
