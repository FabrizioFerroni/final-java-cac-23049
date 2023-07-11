package ar.fabriziodev.finalcacfabrizioferroni.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "DashboardIndex", urlPatterns = "/admin/tablero")
public class DashboardIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/admin/tablero.jsp").forward(req, resp);
    }
}
