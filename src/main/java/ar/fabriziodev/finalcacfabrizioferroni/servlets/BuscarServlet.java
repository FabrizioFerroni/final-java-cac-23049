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
        getServletContext().getRequestDispatcher("/buscar/ticket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String codigo = req.getParameter("codigo"); // Obtener el código del ticket del parámetro del formulario

        resp.sendRedirect("/ticket/" + codigo); // Redireccionar a la URL con el código del ticket en la ruta
    }
}
