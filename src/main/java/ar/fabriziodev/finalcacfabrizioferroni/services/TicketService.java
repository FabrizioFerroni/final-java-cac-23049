package ar.fabriziodev.finalcacfabrizioferroni.services;

import ar.fabriziodev.finalcacfabrizioferroni.models.dto.TicketDto;
import ar.fabriziodev.finalcacfabrizioferroni.services.OradorService;

import ar.fabriziodev.finalcacfabrizioferroni.data.Conexion;
import ar.fabriziodev.finalcacfabrizioferroni.models.Orador;
import ar.fabriziodev.finalcacfabrizioferroni.models.Ticket;
import ar.fabriziodev.finalcacfabrizioferroni.repository.TicketRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TicketService implements TicketRepository {

    private OradorService oradorService;

    private String tableName;

    public TicketService(){
        oradorService = new OradorService();
        this.tableName = "tickets";
    }

    @Override
    public ArrayList<Ticket> findAll() throws Exception {
        String sql = "SELECT * FROM "+this.tableName+" ORDER BY ID DESC";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        ArrayList<Ticket> tickets = new ArrayList<>();


        ResultSet res = pst.executeQuery();

        while(res.next()){
            Ticket ticket = new Ticket();
            Long id = res.getLong(1);
            String codigo = res.getString(2);
            String nombre = res.getString(3);
            String apellido = res.getString(4);
            String email = res.getString(5);
            String dni = res.getString(6);
            Integer cantidad = res.getInt(7);
            Double total = res.getDouble(8);
            String categoria = res.getString(9);
            Timestamp timestamp = res.getTimestamp(10);
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            Long userId  = res.getLong(12);
            Long oradorId  = res.getLong(13);
            Orador orador = oradorService.getById(oradorId);

            ticket.setId(id);
            ticket.setCodigo(codigo);
            ticket.setNombre(nombre);
            ticket.setApellido(apellido);
            ticket.setEmail(email);
            ticket.setDni(dni);
            ticket.setCantidad(cantidad);
            ticket.setTotal(total);
            ticket.setCategoria(categoria);
            ticket.setCreatedAt(createdAt);
            ticket.setUserId(userId);
            ticket.setOrador(orador);

            tickets.add(ticket);
        }

        return tickets;
    }

    @Override
    public ArrayList<Ticket> findAllByUser(Long id) throws Exception {
        String sql = "SELECT * FROM "+this.tableName+" where user_id=? ORDER BY ID DESC";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1,id);

        ArrayList<Ticket> tickets = new ArrayList<>();


        ResultSet res = pst.executeQuery();

        while(res.next()){
            Ticket ticket = new Ticket();
            Long _id = res.getLong(1);
            String codigo = res.getString(2);
            String nombre = res.getString(3);
            String apellido = res.getString(4);
            String email = res.getString(5);
            String dni = res.getString(6);
            Integer cantidad = res.getInt(7);
            Double total = res.getDouble(8);
            String categoria = res.getString(9);
            Timestamp timestamp = res.getTimestamp(10);
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            Long userId  = res.getLong(12);
            Long oradorId = res.getLong(13);
            Orador orador = oradorService.getById(oradorId);

            ticket.setId(_id);
            ticket.setCodigo(codigo);
            ticket.setNombre(nombre);
            ticket.setApellido(apellido);
            ticket.setEmail(email);
            ticket.setDni(dni);
            ticket.setCantidad(cantidad);
            ticket.setTotal(total);
            ticket.setCategoria(categoria);
            ticket.setCreatedAt(createdAt);
            ticket.setUserId(userId);
            ticket.setOrador(orador);

            tickets.add(ticket);
        }
        return tickets;
    }

    @Override
    public Ticket getById(Long id) throws Exception {
        String sql = "select * from "+this.tableName+" where id =? ORDER BY ID DESC";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1,id);

        Ticket ticket = new Ticket();

        ResultSet res = pst.executeQuery();


        if(res.next()) {
            Long _id = res.getLong(1);
            String codigo = res.getString(2);
            String nombre = res.getString(3);
            String apellido = res.getString(4);
            String email = res.getString(5);
            String dni = res.getString(6);
            Integer cantidad = res.getInt(7);
            Double total = res.getDouble(8);
            String categoria = res.getString(9);
            Timestamp timestamp = res.getTimestamp(10);
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            Long userId  = res.getLong(12);
            Long oradorId = res.getLong(13);
            Orador orador = oradorService.getById(oradorId);

            ticket.setId(_id);
            ticket.setCodigo(codigo);
            ticket.setNombre(nombre);
            ticket.setApellido(apellido);
            ticket.setEmail(email);
            ticket.setDni(dni);
            ticket.setCantidad(cantidad);
            ticket.setTotal(total);
            ticket.setCategoria(categoria);
            ticket.setCreatedAt(createdAt);
            ticket.setUserId(userId);
            ticket.setOrador(orador);
        }
        return ticket;
    }

    @Override
    public Ticket getByCode(String codigo) throws Exception {
        String sql = "select * from "+this.tableName+" where codigo =? ORDER BY ID DESC";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, codigo);

        Ticket ticket = new Ticket();

        ResultSet res = pst.executeQuery();
        boolean found = res.next();
        if(found) {
            Long id = res.getLong(1);
            String _codigo = res.getString(2);
            String nombre = res.getString(3);
            String apellido = res.getString(4);
            String email = res.getString(5);
            String dni = res.getString(6);
            Integer cantidad = res.getInt(7);
            Double total = res.getDouble(8);
            String categoria = res.getString(9);
            Timestamp timestamp = res.getTimestamp(10);
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            Long userId  = res.getLong(12);
            Long oradorId = res.getLong(13);
            Orador orador = oradorService.getById(oradorId);


            ticket.setId(id);
            ticket.setCodigo(_codigo);
            ticket.setNombre(nombre);
            ticket.setApellido(apellido);
            ticket.setEmail(email);
            ticket.setDni(dni);
            ticket.setCantidad(cantidad);
            ticket.setTotal(total);
            ticket.setCategoria(categoria);
            ticket.setCreatedAt(createdAt);
            ticket.setUserId(userId);
            ticket.setOradorId(oradorId);
            ticket.setOrador(orador);
        }else{
            ticket = null;
        }


        return ticket;
    }

    @Override
    public ArrayList<Ticket> getByDni(String dni) throws Exception {
        String sql = "SELECT * FROM "+this.tableName+" where dni=? ORDER BY ID DESC";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1,dni);

        ArrayList<Ticket> tickets = new ArrayList<>();


        ResultSet res = pst.executeQuery();

        while(res.next()){
            Ticket ticket = new Ticket();
            Long _id = res.getLong(1);
            String codigo = res.getString(2);
            String nombre = res.getString(3);
            String apellido = res.getString(4);
            String email = res.getString(5);
            String _dni = res.getString(6);
            Integer cantidad = res.getInt(7);
            Double total = res.getDouble(8);
            String categoria = res.getString(9);
            Timestamp timestamp = res.getTimestamp(10);
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            Long userId  = res.getLong(12);
            Long oradorId = res.getLong(13);
            Orador orador = oradorService.getById(oradorId);

            ticket.setId(_id);
            ticket.setCodigo(codigo);
            ticket.setNombre(nombre);
            ticket.setApellido(apellido);
            ticket.setEmail(email);
            ticket.setDni(_dni);
            ticket.setCantidad(cantidad);
            ticket.setTotal(total);
            ticket.setCategoria(categoria);
            ticket.setCreatedAt(createdAt);
            ticket.setUserId(userId);
            ticket.setOrador(orador);

            tickets.add(ticket);
        }
        return tickets;
    }

    @Override
    public boolean create(TicketDto ticket) throws Exception {
        String sql = "INSERT INTO "+this.tableName+ " ";
        sql += " (codigo, nombre, apellido, email, dni, cantidad, total, categoria, created_at, user_id, orador_id)";
        sql += " values (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?) ";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, ticket.getCodigo());
        pst.setString(2, ticket.getNombre());
        pst.setString(3, ticket.getApellido());
        pst.setString(4, ticket.getEmail());
        pst.setString(5, ticket.getDni());
        pst.setInt(6, ticket.getCantidad());
        pst.setDouble(7, ticket.getTotal());
        pst.setString(8, ticket.getCategoria());
        pst.setLong(9, ticket.getUserId());
        pst.setLong(10, ticket.getOradorId());

        int result = pst.executeUpdate();

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(Long id, TicketDto ticket) throws Exception {
        String sql = "UPDATE "+this.tableName+ " ";
        sql += " SET nombre=?, apellido=?, email=?, dni=?, cantidad=?, total=?, categoria=?, ";
        sql += " updated_at=CURRENT_TIMESTAMP WHERE id = ? ";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);


        pst.setString(1, ticket.getNombre());
        pst.setString(2, ticket.getApellido());
        pst.setString(3, ticket.getEmail());
        pst.setString(4, ticket.getDni());
        pst.setInt(5, ticket.getCantidad());
        pst.setDouble(6, ticket.getTotal());
        pst.setString(7, ticket.getCategoria());
        pst.setLong(8, id);

        int result = pst.executeUpdate();

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        String sql = "delete from "+this.tableName+" where id = ? ";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1,id);

        int result  = pst.executeUpdate();

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }
}
