package x4mv.consultasql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/mostrar-iva")
public class MostrarIVA extends HttpServlet {

    // invocando las consultas
    Consultas consulta = new Consultas();


    // Configuración de la base de datos
    private static final String URL = "jdbc:postgresql://localhost:5433/bootcamp_market";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery(consulta.query9)) {  // Cambia la consulta

    ResultSetMetaData meta = rs.getMetaData();
    int columnas = meta.getColumnCount();

    out.println("<html><head>");
    out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles/index.css'>");
    out.println("<title>Tabla de Facturas</title>");
    out.println("</head><body>");
    
    // Contenedor principal para aplicar estilos
    out.println("<div class='container'>");
    out.println("<h1>Tabla Dinámica de Factuas con IVA</h1>");
    out.println("<table>");

    // Cabecera de la tabla
    out.println("<thead><tr>");
    for (int i = 1; i <= columnas; i++) {
        out.println("<th>" + meta.getColumnLabel(i) + "</th>");
    }
    out.println("</tr></thead>");

    // Filas de la tabla
    out.println("<tbody>");
    while (rs.next()) {
        out.println("<tr>");
        for (int i = 1; i <= columnas; i++) {
            out.println("<td>" + rs.getString(i) + "</td>");
        }
        out.println("</tr>");
    }
    out.println("</tbody>");

    out.println("</table>");
    out.println("</div>");  // Cierra el contenedor
    out.println("</body></html>");

    } catch (SQLException e) {
        e.printStackTrace();
        out.println("<p>Error al generar la tabla</p>");
    }

    }
}