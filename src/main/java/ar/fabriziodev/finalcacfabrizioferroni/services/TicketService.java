package ar.fabriziodev.finalcacfabrizioferroni.services;

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

    private String tableName;

    public TicketService(){ this.tableName = "tickets"; }

    @Override
    public ArrayList<Ticket> findAll() throws Exception {
        String sql = "SELECT * FROM "+this.tableName+"";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        ArrayList<Ticket> tickets = new ArrayList<>();

        ResultSet res = pst.executeQuery();

        while(res.next()){
            Long id = res.getLong(1);
            String codigo = res.getString(2);
            String nombre = res.getString(3);
            String apellido = res.getString(4);
            String email = res.getString(5);
            Integer cantidad = res.getInt(6);
            Double total = res.getDouble(7);
            String categoria = res.getString(8);
            Timestamp timestamp = res.getTimestamp(9);
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            tickets.add(new Ticket(id, codigo,  nombre, apellido, email, cantidad, total, categoria, createdAt));
        }
        return tickets;
    }

    @Override
    public Ticket getById(Long id) throws Exception {
        String sql = "select * from "+this.tableName+" where id =?";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1,id);

        Ticket ticket = null;

        ResultSet res = pst.executeQuery();

        if(res.next()) {
            Long _id = res.getLong(1);
            String codigo = res.getString(2);
            String nombre = res.getString(3);
            String apellido = res.getString(4);
            String email = res.getString(5);
            Integer cantidad = res.getInt(6);
            Double total = res.getDouble(7);
            String categoria = res.getString(8);
            Timestamp timestamp = res.getTimestamp(9);
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            ticket = new Ticket(_id, codigo, nombre, apellido, email, cantidad, total, categoria, createdAt);
        }
        return ticket;
    }

    @Override
    public Ticket getByCode(String codigo) throws Exception {
        String sql = "select * from "+this.tableName+" where codigo =?";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, codigo);

        Ticket ticket = null;

        ResultSet res = pst.executeQuery();

        if(res.next()) {
            Long id = res.getLong(1);
            String _codigo = res.getString(2);
            String nombre = res.getString(3);
            String apellido = res.getString(4);
            String email = res.getString(5);
            Integer cantidad = res.getInt(6);
            Double total = res.getDouble(7);
            String categoria = res.getString(8);
            Timestamp timestamp = res.getTimestamp(9);
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            ticket = new Ticket(id, _codigo, nombre, apellido, email, cantidad, total, categoria, createdAt);
        }
        return ticket;
    }

    @Override
    public boolean create(Ticket ticket) throws Exception {
        String sql = "INSERT INTO "+this.tableName+ " ";
        sql += " (codigo, nombre, apellido, email, cantidad, total, categoria, created_at)";
        sql += " values (?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP) ";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, ticket.getCodigo());
        pst.setString(2, ticket.getNombre());
        pst.setString(3, ticket.getApellido());
        pst.setString(4, ticket.getEmail());
        pst.setInt(5, ticket.getCantidad());
        pst.setDouble(6, ticket.getTotal());
        pst.setString(7, ticket.getCategoria());

        int result = pst.executeUpdate();

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(Long id, Ticket ticket) throws Exception {
        String sql = "UPDATE "+this.tableName+ " ";
        sql += " SET nombre=?, apellido=?, email=?, cantidad=?, total=?, categoria=?, ";
        sql += " updated_at=CURRENT_TIMESTAMP WHERE id = ? ";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);


        pst.setString(1, ticket.getNombre());
        pst.setString(2, ticket.getApellido());
        pst.setString(3, ticket.getEmail());
        pst.setInt(4, ticket.getCantidad());
        pst.setDouble(5, ticket.getTotal());
        pst.setString(6, ticket.getCategoria());
        pst.setLong(7, id);

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
