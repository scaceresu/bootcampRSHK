package x4mv.consultasql;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/registroCliente")
public class RegistroServlet extends HttpServlet {

    // Configuración de la conexión a BD
    private static final String URL = "jdbc:postgresql://localhost:5433/bootcamp_market";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        // Capturamos los datos del form
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String cedula = request.getParameter("cedula");
        String telefono = request.getParameter("telefono");

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            // Conectar a la BD
            Class.forName("org.postgresql.Driver"); // cargar el driver
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

                // Preparar sentencia SQL para insertar
                String sql = "INSERT INTO cliente (nombre, apellido, nro_cedula, telefono) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, nombre);
                    System.out.println("===> NOMBREE <=====");
                    System.out.println("EL NOMBRE ES: -> " + nombre);
                    stmt.setString(2, apellido);
                    stmt.setString(3, cedula);
                    stmt.setString(4, telefono);

                    int filas = stmt.executeUpdate();

                    if (filas > 0) {
                        out.println("<h2>✅ Cliente registrado con éxito</h2>");
                    } else {
                        out.println("<h2>⚠️ No se pudo registrar al cliente</h2>");
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}