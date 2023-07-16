package ar.fabriziodev.finalcacfabrizioferroni.services;

import ar.fabriziodev.finalcacfabrizioferroni.data.Conexion;
import ar.fabriziodev.finalcacfabrizioferroni.models.Usuario;
import ar.fabriziodev.finalcacfabrizioferroni.models.dto.UsuarioDto;
import ar.fabriziodev.finalcacfabrizioferroni.repository.AuthRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService implements AuthRepository {

    private String tableName;

    public AuthService() {
        this.tableName = "usuarios";
    }

    @Override
    public boolean register(UsuarioDto usuario) throws Exception {
        String sql = "insert into "+this.tableName;
        sql += " (nombre,apellido,email,username,password,rol,created_at) ";
        sql += "values (?,?,?,?,?,?,CURRENT_TIMESTAMP) ";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        //sql injection!
        pst.setString(1, usuario.getNombre());
        pst.setString(2,usuario.getApellido());
        pst.setString(3,usuario.getEmail());
        pst.setString(4,usuario.getUsername());
        pst.setString(5,usuario.getPassword());
        pst.setString(6, usuario.getRol());

        int result = pst.executeUpdate();

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }


    public Object login(String username, String password) throws Exception{
        String sql = "select * from "+this.tableName+" where username =?";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, username);

        ResultSet res = pst.executeQuery();

        if(res.next()){
            //Hay q chequear el password introducido
            String password_bd = res.getString(6);
            boolean checkPass = BCrypt.checkpw(password, password_bd);
            if(checkPass){
                Long id = res.getLong(1);
                String nombre = res.getString(2);
                String apellido = res.getString(3);
                String email = res.getString(5);
                String username_bd = res.getString(4);
                String rol = res.getString(7);

                Usuario user = new Usuario();

                user.setId(id);
                user.setNombre(nombre);;
                user.setApellido(apellido);
                user.setEmail(email);
                user.setUsername(username_bd);
                user.setRol(rol);

                return user;
//                return user.toString();
            }else{
                return "El usuario y/o contraseñas son incorrectos";
            }
        }
        return "No hemos podido encontrar un usuario con los datos ingresados";
    }
}
