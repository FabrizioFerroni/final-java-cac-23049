package ar.fabriziodev.finalcacfabrizioferroni.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
public class Conexion {

    public static Connection getConnection() {
        Properties properties = new Properties();
        Connection connection = null;

        try (InputStream inputStream = Conexion.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            properties.load(inputStream);

            String hosts = properties.getProperty("DB_HOST");
            String port = properties.getProperty("DB_PORT");
            String password = properties.getProperty("DB_PASSWORD");
            String username = properties.getProperty("DB_USERNAME");

            String driverClassName = "com.mysql.cj.jdbc.Driver";
            String dbName = properties.getProperty("DB_BD");

            Class.forName(driverClassName);

            String url = "jdbc:mysql://" + hosts + ":" + port + "/" + dbName
                    + "?allowPublicKeyRetrieval=true&serverTimeZone=UTC&useSSL=false";

            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException e) {
            connection = null;
            // Error al leer el archivo de propiedades
            System.err.println("Error al leer el archivo de propiedades: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            connection = null;
            // Error al cargar el driver JDBC
            System.err.println("Error al cargar el driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            connection = null;
            // Error al establecer la conexión a la base de datos
            System.err.println("Error al establecer la conexión a la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
