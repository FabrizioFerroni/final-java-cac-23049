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
import java.io.PrintWriter;

@WebServlet(name="showTicket", urlPatterns = "/ticket")
public class ShowTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codigo = req.getPathInfo().substring(1);
        System.out.println(codigo);

        TicketRepository repo = new TicketService();
        HttpSession session = req.getSession();
        try{
            Ticket ticket = repo.getByCode(codigo);

            if(ticket == null){
                session.setAttribute("status", "failed");
                session.setAttribute("msg", "No hemos encontrado un ticket con ese codigo. Intentelo nuevamente.");
                session.setAttribute("codigo", codigo);
                resp.sendRedirect("/buscar");
            }
            req.setAttribute("ticket", ticket);
            getServletContext().getRequestDispatcher("/buscar/ver.jsp").forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            System.out.println(e.getMessage());
        }

//
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {



    }
}
