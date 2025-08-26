package x4mv.vacas.vacas.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(name="nro_cedula")
    private Integer nroCedula;

    private String correo;

    @Column(name = "id_rol", nullable = false)
    private Integer id_rol = 0; // <- solo entero, sin @ManyToOne

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    private String telefono;
    private String contrasena;

    public UsuarioModel() {}

    public UsuarioModel(String nombre, String apellido, Integer nroCedula, String correo, int id_rol,
                        Date fechaIngreso, String telefono, Date fechaNacimiento, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroCedula = nroCedula;
        this.correo = correo;
        this.id_rol = id_rol;
        this.fechaIngreso = fechaIngreso;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public Integer getNroCedula() { return nroCedula; }
    public void setNroCedula(Integer nroCedula) { this.nroCedula = nroCedula; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public int getId_rol() { return id_rol; }           // getter correcto
    public void setId_rol(int id_rol) { this.id_rol = id_rol; } // setter correcto

    public Date getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(Date fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}
