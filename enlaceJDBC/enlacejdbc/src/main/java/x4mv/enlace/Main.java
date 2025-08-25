package x4mv.enlace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Main {
    public static void main(String[] args) {

        Credenciales credenciales = new Credenciales();
        Consultas consultas = new Consultas();

        // String url = "jdbc:postgresql://localhost:5432/"+credenciales.bd; // reemplaza con tu DB
        String url = "jdbc:postgresql://localhost:5433/"+credenciales.db; // reemplaza con tu DB
        String user = credenciales.usuario; // tu usuario
        String password = credenciales.pswd; // tu contraseña

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa!");

            // Crear statement para consultas
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente Limit 3;");

            
            //recorriendo las respuestas
            while (rs.next()) {
                System.out.println(rs.getString("nombre")); // ajusta según tu tabla
            }

            // respondiendo las preguntas
            System.out.println("#1 TOP CLIENTES CON MAS FACTURAS");
            ResultSet pp = stmt.executeQuery(consultas.query1);
            while (pp.next()) {
                int columnas = pp.getMetaData().getColumnCount(); // número de columnas
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(pp.getString(i) + "\t"); // imprime cada columna separada por tab
                }
                System.out.println(); // salto de línea al final de la fila
            }

            System.out.println("#2 TOP CLIENTES QUE MAS GASTARON");
            ResultSet sp = stmt.executeQuery(consultas.query2);
            while (sp.next()) {
                int columnas = sp.getMetaData().getColumnCount(); // número de columnas
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(sp.getString(i) + "\t"); // imprime cada columna separada por tab
                }
                System.out.println(); // salto de línea al final de la fila
            }


            System.out.println("#3 TOP MONEDAS MAS UTILIZADAS");
            ResultSet tp = stmt.executeQuery(consultas.query3);
            while (tp.next()) {
                int columnas = tp.getMetaData().getColumnCount(); // número de columnas
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(tp.getString(i) + "\t"); // imprime cada columna separada por tab
                }
                System.out.println(); // salto de línea al final de la fila
            }

            System.out.println("#4 TOP PROVEEDORES");
            ResultSet cp = stmt.executeQuery(consultas.query4);
            while (cp.next()) {
                int columnas = cp.getMetaData().getColumnCount(); // número de columnas
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(cp.getString(i) + "\t"); // imprime cada columna separada por tab
                }
                System.out.println(); // salto de línea al final de la fila
            }

            System.out.println("#5 PRODUCTOS MAS VENDIDOS");
            ResultSet qp = stmt.executeQuery(consultas.query5);
            while (qp.next()) {
                int columnas = qp.getMetaData().getColumnCount(); // número de columnas
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(qp.getString(i) + "\t"); // imprime cada columna separada por tab
                }
                System.out.println(); // salto de línea al final de la fila
            }

            System.out.println("#6 PRODUCTOS MENOS VENDIDOS");
            ResultSet sexp = stmt.executeQuery(consultas.query6);
            while (sexp.next()) {
                int columnas = sexp.getMetaData().getColumnCount(); // número de columnas
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(sexp.getString(i) + "\t"); // imprime cada columna separada por tab
                }
                System.out.println(); // salto de línea al final de la fila
            }

            System.out.println("#7 FACTURA ESPECIFICA");
            ResultSet sepp = stmt.executeQuery(consultas.query7);
            while (sepp.next()) {
                int columnas = sepp.getMetaData().getColumnCount(); // número de columnas
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(sepp.getString(i) + "\t"); // imprime cada columna separada por tab
                }
                System.out.println(); // salto de línea al final de la fila
            }

            System.out.println("#8 ORDENES SEGUN TOTALES");
            ResultSet op = stmt.executeQuery(consultas.query8);
            while (op.next()) {
                int columnas = op.getMetaData().getColumnCount(); // número de columnas
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(op.getString(i) + "\t"); // imprime cada columna separada por tab
                }
                System.out.println(); // salto de línea al final de la fila
            }

            System.out.println("#9 ORDENES SEGUN TOTALES");
            ResultSet np = stmt.executeQuery(consultas.query9);
            while (np.next()) {
                int columnas = np.getMetaData().getColumnCount(); // número de columnas
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(np.getString(i) + "\t"); // imprime cada columna separada por tab
                }
                System.out.println(); // salto de línea al final de la fila
            }



            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
