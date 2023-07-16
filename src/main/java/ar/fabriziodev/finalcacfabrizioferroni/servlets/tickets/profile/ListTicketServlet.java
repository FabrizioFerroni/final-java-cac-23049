package ar.fabriziodev.finalcacfabrizioferroni.servlets.tickets.profile;

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

@WebServlet(name="listTicket", urlPatterns = "/tickets")
public class ListTicketServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        String rutaActual = requestURI.substring(req.getContextPath().length()).replace(".jsp", "");
        HttpSession session = req.getSession();
        Long userID  = (Long) session.getAttribute("id");


        req.setAttribute("rutaActual", rutaActual);
        TicketRepository repo = new TicketService();
        try{
            if(userID == null){
                resp.sendRedirect("/cerrarsesion");
            }
            ArrayList<Ticket> tickets = repo.findAllByUser(userID);
            req.setAttribute("tickets", tickets);
        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
        }
        getServletContext().getRequestDispatcher("/tickets/listar.jsp").forward(req, resp);
    }
}
