package x4mv.enlace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Main {
    public static void main(String[] args) {

        Credenciales credenciales = new Credenciales();

        String url = "jdbc:postgresql://localhost:5432/"+credenciales.bd; // reemplaza con tu DB
        String user = credenciales.usuario; // tu usuario
        String password = credenciales.pswd; // tu contraseña

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa!");

            // Crear statement para consultas
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente Limit 3;");

            while (rs.next()) {
                System.out.println(rs.getString("nombre")); // ajusta según tu tabla
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
