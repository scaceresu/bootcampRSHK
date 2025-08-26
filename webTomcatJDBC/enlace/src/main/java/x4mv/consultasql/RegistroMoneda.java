package x4mv.consultasql;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/registroMoneda")
public class RegistroMoneda extends HttpServlet {

    private static final String URL = "jdbc:postgresql://localhost:5433/bootcamp_market";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nombre = request.getParameter("nombre_moneda");

        // Ahora vamos a insertar también el id calculado
        String sql = "INSERT INTO moneda(id, nombre) VALUES (?, ?)";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = response.getWriter();
             Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // 1️⃣ Calcular el próximo id
            int nextId = 1; // valor por defecto si la tabla está vacía
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT COALESCE(MAX(id), 0) + 1 FROM moneda")) {
                if (rs.next()) {
                    nextId = rs.getInt(1);
                }
            }

            // 2️⃣ Insertar con el id correcto
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, nextId);
                ps.setString(2, nombre);

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    out.println("<h2>Moneda registrada con éxito ✅</h2>");
                } else {
                    out.println("<h2 style='color:red'>No se insertó ningún registro ❌</h2>");
                }
            }

            out.println("<a href='http://localhost:8080/tabla-dinamica-1.0-SNAPSHOT/'>Volver</a>");

        } catch (SQLException e) {
            e.printStackTrace(); // log en consola
            try (PrintWriter out = response.getWriter()) {
                out.println("<h2 style='color:red'>Error al registrar moneda❌</h2>");
                out.println("<p>" + e.getMessage() + "</p>");
                out.println("<a href='http://localhost:8080/tabla-dinamica-1.0-SNAPSHOT/'>Volver</a>");
            }
        }
    }
}
