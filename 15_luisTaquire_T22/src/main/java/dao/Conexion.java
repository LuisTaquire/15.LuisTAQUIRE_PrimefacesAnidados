package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection cnx = null;

    public static Connection conectar() throws Exception {

        try {

            String user = "sa";
            String pwd = "rut12345";
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost;databaseName=anidado";

            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);

        } catch (Exception e) {
            System.out.println("Hay un error de conexión SQL SERVER" + e.getMessage());
        }
        return cnx;
    }

    public static void cerrarCnx() throws Exception {
        if (Conexion.cnx != null) {
            cnx.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Conexion cnx = new Conexion();
        if (cnx.conectar() != null) {
            System.out.println("Conectado ");
        } else {
            System.out.println("Falla Conectar ");
        }
    }
}
