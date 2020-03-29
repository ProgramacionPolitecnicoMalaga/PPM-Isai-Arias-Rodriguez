package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conecta {
    private final static  String url="jdbc:mysql://vps791421.ovh.net:3306/Empleados";
    private final static String usuario="empleadosuser";
    private final static String password="Perro20";
    private Connection conn;
    public Conecta() throws SQLException {
        conn = DriverManager.getConnection(url,usuario,password);
    }
    public Connection getConn(){
        return conn;
    }
    public ResultSet read(String consulta) throws SQLException {
        conn.prepareStatement(consulta).executeQuery();
        return conn.prepareStatement(consulta).executeQuery();
    }
    public void create(String consulta) throws SQLException {
        conn.prepareStatement(consulta).executeUpdate();
        System.out.println("Sucess");
    }
    public void delete(String consulta) throws SQLException {
         conn.prepareStatement(consulta).executeUpdate(); }


}
