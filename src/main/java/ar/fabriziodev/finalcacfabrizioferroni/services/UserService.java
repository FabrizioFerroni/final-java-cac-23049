package ar.fabriziodev.finalcacfabrizioferroni.services;

import ar.fabriziodev.finalcacfabrizioferroni.data.Conexion;
import ar.fabriziodev.finalcacfabrizioferroni.models.Usuario;
import ar.fabriziodev.finalcacfabrizioferroni.models.dto.UsuarioDto;
import ar.fabriziodev.finalcacfabrizioferroni.repository.UserRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class UserService implements UserRepository {

    private String tableName;

    public UserService() {
        this.tableName = "usuarios";
    }
    @Override
    public ArrayList<Usuario> findAll() throws Exception {
        String sql = "SELECT * FROM "+this.tableName+" ORDER BY ID DESC";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        ArrayList<Usuario> users = new ArrayList<>();

        ResultSet res = pst.executeQuery();

        while(res.next()){
            Usuario user = new Usuario();
            Long id = res.getLong(1);
            String nombre = res.getString(2);
            String apellido = res.getString(3);
            String username_bd = res.getString(4);
            String email = res.getString(5);
            String rol = res.getString(7);
            Timestamp timestamp = res.getTimestamp(8);
            LocalDateTime createdAt = timestamp.toLocalDateTime();

            user.setId(id);
            user.setNombre(nombre);;
            user.setApellido(apellido);
            user.setEmail(email);
            user.setUsername(username_bd);
            user.setRol(rol);
            user.setCreatedAt(createdAt);

            users.add(user);
        }
        return users;
    }

    @Override
    public Usuario getById(Long id) throws Exception {
        String sql = "select * from "+this.tableName+" where id =? ORDER BY ID DESC";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1,id);

        Usuario user = new Usuario();

        ResultSet res = pst.executeQuery();

        if(res.next()) {
            Long _id = res.getLong(1);
            String nombre = res.getString(2);
            String apellido = res.getString(3);
            String username = res.getString(4);
            String email = res.getString(5);
            String rol = res.getString(7);
            Timestamp timestamp = res.getTimestamp(8);
            LocalDateTime createdAt = timestamp.toLocalDateTime();

            user.setId(_id);
            user.setNombre(nombre);
            user.setApellido(apellido);
            user.setEmail(email);
            user.setUsername(username);
            user.setRol(rol);
            user.setCreatedAt(createdAt);
        }
        return user;
    }

    @Override
    public boolean update(Long id, UsuarioDto usuario) throws Exception {
        String sql = "UPDATE "+this.tableName+" SET nombre=?,apellido=?,email=?, username=?, rol=?, updated_at=CURRENT_TIMESTAMP WHERE id = ?";

        Connection con = Conexion.getConnection();

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, usuario.getNombre());
        pst.setString(2, usuario.getApellido());
        pst.setString(3, usuario.getEmail());
        pst.setString(4, usuario.getUsername());
        pst.setString(5, usuario.getRol());
        pst.setLong(6, id);

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

        int rs  = pst.executeUpdate();

        if(rs > 0){
            return true;
        }else{
            return false;
        }
    }


    private Date dateFrom(LocalDateTime ldt) {
        java.util.Date date = Date.from(ldt.toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        return new java.sql.Date(date.getTime());

        //Calendar
        //Gregorian Calendar
    }
}
