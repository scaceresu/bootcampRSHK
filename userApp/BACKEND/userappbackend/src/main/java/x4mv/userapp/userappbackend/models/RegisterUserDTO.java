package x4mv.userapp.userappbackend.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class RegisterUserDTO {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    private String nombre;
    private String apellido;
    @Column(name = "nro_cedula")
    int nroCedula;
    private String correo;
    @Column(name = "id_rol")
    private Integer idRol;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;
    @Column(name = "dias_vacaciones")
    private int diasVacaciones = 0;
    private boolean estado;
    private String contrasena;
    private String telefono;
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Column(name = "id_cargo")
    private Integer idCargo;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "requiere_cambio_contrasena")
    private boolean requiereCambioContrasena = false;


    public RegisterUserDTO() {
    }
   
    public RegisterUserDTO(String nombre, String apellido, int nroCedula, String correo, Integer idRol,
            LocalDate fechaIngreso, int diasVacaciones, boolean estado, String contrasena, String telefono,
            Integer idEquipo, Integer idCargo, LocalDate fechaNacimiento, boolean requiereCambioContrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroCedula = nroCedula;
        this.correo = correo;
        this.idRol = idRol;
        this.fechaIngreso = fechaIngreso;
        this.diasVacaciones = diasVacaciones;
        this.estado = estado;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.idEquipo = idEquipo;
        this.idCargo = idCargo;
        this.fechaNacimiento = fechaNacimiento;
        this.requiereCambioContrasena = requiereCambioContrasena;
    }



     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getNroCedula() {
        return nroCedula;
    }
    public void setNroCedula(int nroCedula) {
        this.nroCedula = nroCedula;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Integer getIdRol() {
        return idRol;
    }
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public int getDiasVacaciones() {
        return diasVacaciones;
    }
    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Integer getIdEquipo() {
        return idEquipo;
    }
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }
    public Integer getIdCargo() {
        return idCargo;
    }
    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public boolean isRequiereCambioContrasena() {
        return requiereCambioContrasena;
    }
    public void setRequiereCambioContrasena(boolean requiereCambioContrasena) {
        this.requiereCambioContrasena = requiereCambioContrasena;
    }
    

    

}
