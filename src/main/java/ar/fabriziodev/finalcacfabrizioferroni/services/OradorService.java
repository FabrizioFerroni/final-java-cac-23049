package ar.fabriziodev.finalcacfabrizioferroni.services;

import ar.fabriziodev.finalcacfabrizioferroni.data.Conexion;
import ar.fabriziodev.finalcacfabrizioferroni.models.Orador;
import ar.fabriziodev.finalcacfabrizioferroni.models.dto.OradorDto;
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
        String sql = "SELECT * FROM "+this.tableName+" ORDER BY ID DESC";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        ArrayList<Orador> oradores = new ArrayList<>();


        ResultSet res = pst.executeQuery();

        while(res.next()){
            Orador orador = new Orador();

            Long id = res.getLong(1);
            String codigo = res.getString(2);
            String nombre = res.getString(3);
            String apellido = res.getString(4);
            String tema = res.getString(5);
            String descripcion = res.getString(6);
            Timestamp timestamp = res.getTimestamp(7);
            LocalDateTime createdAt = timestamp.toLocalDateTime();

            orador.setId(id);
            orador.setCodigo(codigo);
            orador.setNombre(nombre);
            orador.setApellido(apellido);
            orador.setTema(tema);
            orador.setDescripcion(descripcion);
            orador.setCreatedAt(createdAt);

            oradores.add(orador);
        }
        return oradores;
    }

    @Override
    public Orador getById(Long id) throws Exception {
            String sql = "select * from "+this.tableName+" where id =? ORDER BY ID DESC";

            //Obtener la Conection
            Connection con = Conexion.getConnection();

            //PreparedStatement con mi sql
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setLong(1,id);

            Orador orador = new Orador();

            ResultSet res = pst.executeQuery();

            if(res.next()) {
                Long _id = res.getLong(1);
                String codigo = res.getString(2);
                String nombre = res.getString(3);
                String apellido = res.getString(4);
                String tema = res.getString(5);
                String descripcion = res.getString(6);
                Timestamp timestamp = res.getTimestamp(7);
                LocalDateTime createdAt = timestamp.toLocalDateTime();

                orador.setId(_id);
                orador.setCodigo(codigo);
                orador.setNombre(nombre);
                orador.setApellido(apellido);
                orador.setTema(tema);
                orador.setDescripcion(descripcion);
                orador.setCreatedAt(createdAt);
            }
            return orador;
    }

    @Override
    public boolean create(OradorDto orador) throws Exception {
        String sql = "INSERT INTO "+this.tableName+ " ";
        sql += " (codigo, nombre, apellido, tema, descripcion, created_at)";
        sql += " values (?, ?, ?, ?, ?, CURRENT_TIMESTAMP) ";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, orador.getCodigo());
        pst.setString(2, orador.getNombre());
        pst.setString(3, orador.getApellido());
        pst.setString(4, orador.getTema());
        pst.setString(5, orador.getDescripcion());

        int result = pst.executeUpdate();

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(Long id, OradorDto orador) throws Exception {
        String sql = "UPDATE "+this.tableName+ " ";
        sql += " SET nombre=?,apellido=?,tema=?, descripcion=? ,updated_at=CURRENT_TIMESTAMP WHERE id = ? ";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, orador.getNombre());
        pst.setString(2, orador.getApellido());
        pst.setString(3, orador.getTema());
        pst.setString(4, orador.getDescripcion());
        pst.setLong(5, id);


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
