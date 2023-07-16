package ar.fabriziodev.finalcacfabrizioferroni.servlets.tickets;

import ar.fabriziodev.finalcacfabrizioferroni.models.Ticket;
import ar.fabriziodev.finalcacfabrizioferroni.models.dto.TicketDto;
import ar.fabriziodev.finalcacfabrizioferroni.repository.TicketRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="editTicket", urlPatterns = "/admin/ticket/editar")
public class EditTicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getPathInfo().substring(1);
        TicketRepository repo = new TicketService();
        try{
            Ticket ticket = repo.getById(Long.parseLong(id));
            req.setAttribute("ticket", ticket);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            System.out.println(e.getMessage());
        }
        getServletContext().getRequestDispatcher("/admin/tickets/editar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String dni = req.getParameter("dni");
        Integer cantidad = Integer.valueOf(req.getParameter("cantidad"));
        Double total = Double.valueOf(req.getParameter("total"));
        String categoria = req.getParameter("categoria");
        String id = req.getPathInfo().substring(1);

        if (nombre == "" || apellido == "" || email == "" || categoria == "" || cantidad.equals(0) || total.equals(0)) {
            req.setAttribute("status", "warning");
            req.setAttribute("msg", "Todos los campos son requeridos");
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("email", email);
            req.setAttribute("cantidad", cantidad);
            req.setAttribute("total", total);
            req.setAttribute("categoria", categoria);
            getServletContext().getRequestDispatcher("/admin/tickets/editar.jsp").forward(req, resp);
        }

        nombre = toNomProp(nombre);
        apellido = toNomProp(apellido);

        TicketDto edit_ticket = new TicketDto();

        edit_ticket.setNombre(nombre);
        edit_ticket.setApellido(apellido);
        edit_ticket.setEmail(email);
        edit_ticket.setDni(dni);
        edit_ticket.setCantidad(cantidad);
        edit_ticket.setTotal(total);
        edit_ticket.setCategoria(categoria);

        TicketRepository repo = new TicketService();
        HttpSession session = req.getSession();

        try{
            boolean result = repo.update(Long.parseLong(id), edit_ticket);
            if(result){
                session.setAttribute("status", "success");
                session.setAttribute("msg", "Se ha actualizado con éxito el ticket");
                resp.sendRedirect("/admin/tickets");
            }else{
                req.setAttribute("status", "failed");
                req.setAttribute("msg", "No se ha podido editar el ticket.");
                req.setAttribute("nombre", nombre);
                req.setAttribute("apellido", apellido);
                req.setAttribute("email", email);
                req.setAttribute("dni", dni);
                req.setAttribute("cantidad", cantidad);
                req.setAttribute("total", total);
                req.setAttribute("categoria", categoria);
                getServletContext().getRequestDispatcher("/admin/tickets/editar.jsp").forward(req, resp);
            }
        } catch (Exception ex){
            req.setAttribute("status", "failed");
            req.setAttribute("msg", ex.getMessage());
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("email", email);
            req.setAttribute("dni", dni);
            req.setAttribute("cantidad", cantidad);
            req.setAttribute("total", total);
            req.setAttribute("categoria", categoria);
            getServletContext().getRequestDispatcher("/admin/tickets/editar.jsp").forward(req, resp);
            System.out.println(ex.getMessage());
        }
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
