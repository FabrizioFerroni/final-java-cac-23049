package ar.fabriziodev.finalcacfabrizioferroni.servlets.tickets;

import ar.fabriziodev.finalcacfabrizioferroni.models.Ticket;
import ar.fabriziodev.finalcacfabrizioferroni.repository.TicketRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "readTickets" , urlPatterns = "/admin/tickets")
public class ReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketRepository repo = new TicketService();
        try{
            ArrayList<Ticket> tickets = repo.findAll();
            req.setAttribute("tickets", tickets);
        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
        }
        getServletContext().getRequestDispatcher("/admin/tickets/listar.jsp").forward(req, resp);
    }
}

