package x4mv.consultasql;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/registroCliente")
public class RegistroCliente extends HttpServlet {

    private static final String URL = "jdbc:postgresql://localhost:5433/bootcamp_market";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String nroCedula = request.getParameter("nro_cedula");
        String telefono = request.getParameter("telefono");

        String sql = "INSERT INTO cliente (nombre, apellido, nro_cedula, telefono) VALUES (?, ?, ?, ?)";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (PrintWriter out = response.getWriter();
             Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, nroCedula);
            ps.setString(4, telefono);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                out.println("<h2>Cliente registrado con éxito ✅</h2>");
            } else {
                out.println("<h2 style='color:red'>No se insertó ningún registro ❌</h2>");
            }

            out.println("<a href='http://localhost:8080/tabla-dinamica-1.0-SNAPSHOT/'>Volver</a>");

        } catch (SQLException e) {
            e.printStackTrace(); // log en consola
            try (PrintWriter out = response.getWriter()) {
                out.println("<h2 style='color:red'>Error al registrar cliente ❌</h2>");
                out.println("<p>" + e.getMessage() + "</p>");
                out.println("<a href='http://localhost:8080/tabla-dinamica-1.0-SNAPSHOT/'>Volver</a>");
            }
        }
    }
}
