package ar.fabriziodev.finalcacfabrizioferroni.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="buscarServlet", urlPatterns = "/buscar")
public class BuscarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String rutaActual = requestURI.substring(req.getContextPath().length()).replace(".jsp", "");

        req.setAttribute("rutaActual", rutaActual);
        getServletContext().getRequestDispatcher("/buscar/ticket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String codigo = req.getParameter("codigo");
        String dni = req.getParameter("dni");

        if(codigo != null && dni == null){
            resp.sendRedirect("/ticket/" + codigo);
        }

        if(codigo == null && dni != null){
            resp.sendRedirect("/tickets/dni/" + dni);
        }
    }
}
