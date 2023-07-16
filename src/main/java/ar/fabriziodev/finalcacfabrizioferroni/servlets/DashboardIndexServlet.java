package ar.fabriziodev.finalcacfabrizioferroni.servlets;

import ar.fabriziodev.finalcacfabrizioferroni.repository.HomeRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.HomeService;
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
        String requestURI = req.getRequestURI();
        String rutaActual = requestURI.substring(req.getContextPath().length()).replace(".jsp", "");

        HomeRepository repo = new HomeService();
        try {
            int countOradores = repo.countOradores();
            int countTickets = repo.countTickets();
            int countUsers = repo.countUsers();
            req.setAttribute("c_oradores", countOradores);
            req.setAttribute("c_tickets", countTickets);
            req.setAttribute("c_user", countUsers);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        req.setAttribute("rutaActual", rutaActual);
            getServletContext().getRequestDispatcher("/admin/tablero.jsp").forward(req, resp);
    }
}
