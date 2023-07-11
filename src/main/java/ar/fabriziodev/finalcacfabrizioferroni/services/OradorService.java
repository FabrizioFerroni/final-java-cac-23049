package ar.fabriziodev.finalcacfabrizioferroni.services;

import ar.fabriziodev.finalcacfabrizioferroni.data.Conexion;
import ar.fabriziodev.finalcacfabrizioferroni.models.Orador;
import ar.fabriziodev.finalcacfabrizioferroni.repository.OradorRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class OradorService implements OradorRepository {
    private String tableName;

    public OradorService(){ this.tableName = "oradores";}

    @Override
    public ArrayList<Orador> findAll() throws Exception {
        String sql = "SELECT * FROM "+this.tableName+"";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        ArrayList<Orador> oradores = new ArrayList<>();

        ResultSet res = pst.executeQuery();

        while(res.next()){
            Long id = res.getLong(1);
            String codigo = res.getString(2);
            String nombre = res.getString(3);
            String apellido = res.getString(4);
            String tema = res.getString(5);
            Timestamp timestamp = res.getTimestamp(6);
            LocalDateTime createdAt = timestamp.toLocalDateTime();
            oradores.add(new Orador(id, codigo,  nombre, apellido, tema, createdAt));
        }
        return oradores;
    }

    @Override
    public Orador getById(Long id) throws Exception {
            String sql = "select * from "+this.tableName+" where id =?";

            //Obtener la Conection
            Connection con = Conexion.getConnection();

            //PreparedStatement con mi sql
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setLong(1,id);

            Orador orador = null;

            ResultSet res = pst.executeQuery();

            if(res.next()) {
                Long _id = res.getLong(1);
                String codigo = res.getString(2);
                String nombre = res.getString(3);
                String apellido = res.getString(4);
                String tema = res.getString(5);
                Timestamp timestamp = res.getTimestamp(6);
                LocalDateTime createdAt = timestamp.toLocalDateTime();

                orador = new Orador(_id, codigo, nombre, apellido, tema, createdAt);
            }
            return orador;
    }

    @Override
    public boolean create(Orador orador) throws Exception {
        String sql = "INSERT INTO "+this.tableName+ " ";
        sql += " (codigo, nombre, apellido, tema, created_at)";
        sql += " values (?, ?, ?, ?, CURRENT_TIMESTAMP) ";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, orador.getCodigo());
        pst.setString(2, orador.getNombre());
        pst.setString(3, orador.getApellido());
        pst.setString(4, orador.getTema());

        int result = pst.executeUpdate();

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(Long id, Orador orador) throws Exception {
        String sql = "UPDATE "+this.tableName+ " ";
        sql += " SET nombre=?,apellido=?,tema=?,updated_at=CURRENT_TIMESTAMP WHERE id = ? ";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, orador.getNombre());
        pst.setString(2, orador.getApellido());
        pst.setString(3, orador.getTema());
        pst.setLong(4, id);


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
