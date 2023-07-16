package ar.fabriziodev.finalcacfabrizioferroni.servlets;

import ar.fabriziodev.finalcacfabrizioferroni.models.Ticket;
import ar.fabriziodev.finalcacfabrizioferroni.repository.TicketRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="buscarDniServlet", urlPatterns = "/tickets/dni")
public class BuscarDniServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dni = req.getPathInfo().substring(1);
        String requestURI = req.getRequestURI();
        String rutaActual = requestURI.substring(req.getContextPath().length()).replace(".jsp", "");

        req.setAttribute("rutaActual", rutaActual);

        TicketRepository repo = new TicketService();
        HttpSession session = req.getSession();
        try{
            ArrayList<Ticket> tickets = repo.getByDni(dni);

            if(tickets == null){
                session.setAttribute("status", "failed");
                session.setAttribute("msg", "No hemos encontrado un ticket con ese dni. Intentelo nuevamente.");
                session.setAttribute("dni", dni);
                resp.sendRedirect("/buscar");
            }
            req.setAttribute("dni", dni);
            req.setAttribute("tickets", tickets);
            getServletContext().getRequestDispatcher("/tickets/listar_dni.jsp").forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            System.out.println(e.getMessage());
        }
    }


}
