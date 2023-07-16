package ar.fabriziodev.finalcacfabrizioferroni.services;

import ar.fabriziodev.finalcacfabrizioferroni.data.Conexion;
import ar.fabriziodev.finalcacfabrizioferroni.repository.HomeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HomeService implements HomeRepository {
    @Override
    public int countOradores() throws Exception {
        String sql = "SELECT COUNT(*) AS TOTAL_REG FROM `oradores`";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet res = pst.executeQuery();

        // Obtener el resultado
        int totalRegistros = 0;
        if (res.next()) {
            totalRegistros = res.getInt("TOTAL_REG");
        }
        return totalRegistros;
    }

    @Override
    public int countTickets() throws Exception {
        String sql = "SELECT COUNT(*) AS TOTAL_REG FROM `tickets`";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet res = pst.executeQuery();

        // Obtener el resultado
        int totalRegistros = 0;
        if (res.next()) {
            totalRegistros = res.getInt("TOTAL_REG");
        }
        return totalRegistros;
    }

    @Override
    public int countUsers() throws Exception {
        String sql = "SELECT COUNT(*) AS TOTAL_REG FROM `usuarios`";

        //Obtener la Conection
        Connection con = Conexion.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet res = pst.executeQuery();

        // Obtener el resultado
        int totalRegistros = 0;
        if (res.next()) {
            totalRegistros = res.getInt("TOTAL_REG");
        }
        return totalRegistros;
    }
}
