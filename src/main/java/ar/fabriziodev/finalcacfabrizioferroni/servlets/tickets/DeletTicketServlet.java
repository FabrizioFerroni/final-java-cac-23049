package ar.fabriziodev.finalcacfabrizioferroni.servlets.tickets;

import ar.fabriziodev.finalcacfabrizioferroni.repository.TicketRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "deletTicket", urlPatterns = "/admin/ticket/eliminar")
public class DeletTicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getPathInfo().substring(1);
        TicketRepository repo = new TicketService();

        HttpSession session = req.getSession();
        try {
            boolean result = repo.delete(Long.parseLong(id));
            if (result) {
                session.setAttribute("status", "success");
                session.setAttribute("msg", "Se ha borrado con éxito el ticket");
                resp.sendRedirect("/admin/tickets");
            } else {
                session.setAttribute("status", "failed");
                session.setAttribute("msg", "No se ha borrado el ticket");
                resp.sendRedirect("/admin/tickets");
            }
        } catch (Exception ex) {
            session.setAttribute("status", "failed");
            session.setAttribute("msg", ex.getMessage());
            resp.sendRedirect("/admin/tickets");
            System.out.println(ex.getMessage());
        }
    }
}
