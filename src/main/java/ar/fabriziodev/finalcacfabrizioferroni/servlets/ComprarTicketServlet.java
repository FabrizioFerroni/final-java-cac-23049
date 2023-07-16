package ar.fabriziodev.finalcacfabrizioferroni.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import ar.fabriziodev.finalcacfabrizioferroni.models.Orador;
import ar.fabriziodev.finalcacfabrizioferroni.models.Ticket;
import ar.fabriziodev.finalcacfabrizioferroni.models.Usuario;
import ar.fabriziodev.finalcacfabrizioferroni.models.dto.TicketDto;
import ar.fabriziodev.finalcacfabrizioferroni.repository.OradorRepository;
import ar.fabriziodev.finalcacfabrizioferroni.repository.TicketRepository;
import ar.fabriziodev.finalcacfabrizioferroni.services.OradorService;
import ar.fabriziodev.finalcacfabrizioferroni.services.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name ="ComprarTicket", urlPatterns = "/comprar/ticket")
public class ComprarTicketServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String rutaActual = requestURI.substring(req.getContextPath().length()).replace(".jsp", "");

        req.setAttribute("rutaActual", rutaActual);

        OradorRepository repo = new OradorService();
        try {
            ArrayList<Orador> oradores = repo.findAll();
            req.setAttribute("oradores", oradores);
        }catch (Exception e) {

        }

        getServletContext().getRequestDispatcher("/comprar/ticket.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String dni = req.getParameter("dni");
        Integer cantidad = Integer.valueOf(req.getParameter("cantidad"));
        Double total = Double.valueOf(req.getParameter("total"));
        String categoria = req.getParameter("categoria");
        HttpSession session = req.getSession();
        Long userID  = (Long) session.getAttribute("id");
        Long oradorId  = Long.valueOf(req.getParameter("orador_id"));

        if (nombre == "" || apellido == "" || email == "" || dni == "" || categoria == "" || cantidad.equals(0) || total.equals(0) || oradorId == null) {
            req.setAttribute("status", "warning");
            req.setAttribute("msg", "Todos los campos son requeridos");
            req.setAttribute("nombre", nombre);
            req.setAttribute("apellido", apellido);
            req.setAttribute("email", email);
            req.setAttribute("dni", dni);
            req.setAttribute("cantidad", cantidad);
            req.setAttribute("total", total);
            req.setAttribute("categoria", categoria);
            req.setAttribute("orador_id", oradorId);
            getServletContext().getRequestDispatcher("/comprar/ticket.jsp").forward(req, resp);
        }
        String codigo = genCode(10);

        nombre = toNomProp(nombre);
        apellido = toNomProp(apellido);

        TicketDto new_ticket = new TicketDto();

        new_ticket.setCodigo(codigo);
        new_ticket.setNombre(nombre);
        new_ticket.setApellido(apellido);
        new_ticket.setEmail(email);
        new_ticket.setDni(dni);
        new_ticket.setCantidad(cantidad);
        new_ticket.setTotal(total);
        new_ticket.setCategoria(categoria);
        new_ticket.setUserId(userID);
        new_ticket.setOradorId(oradorId);

        TicketRepository repo = new TicketService();

        try{
            boolean result  = repo.create(new_ticket);
            if(result){
                session.setAttribute("status", "success");
                session.setAttribute("msg", "Gracias por comprar en nuestra tienda, te pasamos un resumen de tu compra");
                session.setAttribute("codigo2", codigo);
                session.setAttribute("nombre2", nombre);
                session.setAttribute("apellido2", apellido);
                session.setAttribute("email2", email);
                session.setAttribute("dni2", dni);
                session.setAttribute("cantidad2", cantidad);
                session.setAttribute("total2", total);
                session.setAttribute("categoria2", categoria);
                session.setAttribute("orador_id2", oradorId);
                resp.sendRedirect("/comprar/ticket");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static String genCode(int length) {
        String bank = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(bank.length());
            randomString.append(bank.charAt(randomIndex));
        }

        return randomString.toString();
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
