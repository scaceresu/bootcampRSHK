package x4mv.consultasql;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/registroProducto")
public class RegistroProducto extends HttpServlet {

    private static final String URL = "jdbc:postgresql://localhost:5433/bootcamp_market";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nombre = request.getParameter("nombre");
        int precio = Integer.parseInt(request.getParameter("precio"));
        int proveedor_id = Integer.parseInt(request.getParameter("proveedor_id"));
        int costo = Integer.parseInt(request.getParameter("costo"));

        // Consulta para obtener el siguiente id
        String sqlNextId = "SELECT COALESCE(MAX(id), 0) + 1 AS next_id FROM producto";
        String sqlInsert = "INSERT INTO producto(id, nombre, precio, proveedor_id, costo) VALUES (?, ?, ?, ?, ?)";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = response.getWriter();
             Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // ✅ Obtener el próximo id disponible
            int nextId = 1;
            try (PreparedStatement psNext = conn.prepareStatement(sqlNextId);
                 ResultSet rs = psNext.executeQuery()) {
                if (rs.next()) {
                    nextId = rs.getInt("next_id");
                }
            }

            // ✅ Insertar el proveedor con ese id
            try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
                psInsert.setInt(1, nextId);
                psInsert.setString(2, nombre);
                psInsert.setInt(3, precio);
                psInsert.setInt(4, proveedor_id );
                psInsert.setInt(5, costo);

                int rows = psInsert.executeUpdate();
                if (rows > 0) {
                    out.println("<h2>Proveedor registrado con éxito ✅</h2>");
                    out.println("<p>ID asignado: " + nextId + "</p>");
                } else {
                    out.println("<h2 style='color:red'>No se insertó ningún registro ❌</h2>");
                }
            }

            out.println("<a href='http://localhost:8080/tabla-dinamica-1.0-SNAPSHOT/'>Volver</a>");

        } catch (SQLException e) {
            e.printStackTrace(); // log en consola
            try (PrintWriter out = response.getWriter()) {
                out.println("<h2 style='color:red'>Error al registrar proveedor ❌</h2>");
                out.println("<p>" + e.getMessage() + "</p>");
                out.println("<a href='http://localhost:8080/tabla-dinamica-1.0-SNAPSHOT/'>Volver</a>");
            }
        }
    }
}
