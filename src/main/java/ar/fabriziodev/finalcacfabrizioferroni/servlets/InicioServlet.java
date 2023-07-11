package ar.fabriziodev.finalcacfabrizioferroni.servlets;

import ar.fabriziodev.finalcacfabrizioferroni.models.Orador;
import ar.fabriziodev.finalcacfabrizioferroni.repository.OradorRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.OradorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "index" , urlPatterns = "/")
public class InicioServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqUri = req.getRequestURI().toString();

        if(reqUri != null){
            resp.sendRedirect("/");
        }else{
            getServletContext().getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String tema = req.getParameter("tema");

        if(nombre == "" || apellido == "" || tema == "" ){
            req.setAttribute("status", "warning");
            req.setAttribute("msg", "Todos los campos son requeridos");
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("tema", tema);
            getServletContext().getRequestDispatcher("index.jsp").forward(req, resp);
        }
        String codigo = genCode(10);

        nombre = toNomProp(nombre);
        apellido = toNomProp(apellido);

        Orador new_orador = new Orador(codigo, nombre, apellido, tema);

        OradorRepository repo = new OradorService();
        HttpSession session = req.getSession();

        try{
            boolean result = repo.create(new_orador);
            if(result){
                session.setAttribute("status", "success");
                session.setAttribute("msg", "Te has registrado con éxito, este es tu credencial de acceso");
                session.setAttribute("nombre3", nombre);
                session.setAttribute("apellido3", apellido);
                session.setAttribute("tema2", tema);
                session.setAttribute("codigo", codigo);
                resp.sendRedirect("/#convertite-en-orador");
            }else{
                session.setAttribute("status", "failed");
                session.setAttribute("msg", "No te has podido registrar como orador.");
                session.setAttribute("nombre2", nombre);
                session.setAttribute("apellido2", apellido);
                session.setAttribute("tema", tema);
                resp.sendRedirect("/#convertite-en-orador");
            }
        }catch(Exception e){
            req.setAttribute("status", "failed");
            req.setAttribute("msg", e.getMessage());
            resp.sendRedirect("/#convertite-en-orador");
        }
    }

    private static String genCode(int length) {
        String bank = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(bank.length());
            randomString.append(bank.charAt(randomIndex));
        }

        return randomString.toString();
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
