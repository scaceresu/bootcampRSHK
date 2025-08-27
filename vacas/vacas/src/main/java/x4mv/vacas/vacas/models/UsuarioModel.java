package x4mv.vacas.vacas.models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import org.postgresql.util.PGInterval;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    Long id;
    String nombre;
    String apellido;
    @Column(name = "nro_cedula")
    int nroCedula;
    String correo;
    @Column(name = "id_rol")
    Long idRol;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_ingreso")
    Date fechaIngreso;
    String antiguedad;
    @Column(name = "dias_vacaciones")
    int diasVacaciones = 0;
    boolean estado;
    String contrasena;
    String telefono;
    @Column(name = "id_equipo")
    Long idEquipo;
    @Column(name = "id_cargo")
    Long idCargo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_nacimiento")
    Date fechaNacimiento;
    @Column(name = "dias_vacaciones_restantes")
    int diasVacacionesRestantes = 30;
    @Column(name = "requiere_cambio_contrasena")
    boolean requiereCambioContrasena = false;

    public UsuarioModel(){

    }

    public UsuarioModel(String nombre, String apellido, int nroCedula, String correo, Long idRol, Date fechaIngreso,
            String contrasena, String telefono, Long idEquipo, Long idCargo, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroCedula = nroCedula;
        this.correo = correo;
        this.idRol = idRol;
        this.fechaIngreso = fechaIngreso;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.idEquipo = idEquipo;
        this.idCargo = idCargo;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Long getIdRol() {
        return idRol;
    }
    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;

        calcularAntiguedad(fechaIngreso);
    }
    public String getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
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
    public Long getIdEquipo() {
        return idEquipo;
    }
    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }
    public Long getIdCargo() {
        return idCargo;
    }
    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getDiasVacacionesRestantes() {
        return diasVacacionesRestantes;
    }
    public void setDiasVacacionesRestantes(int diasVacacionesRestantes) {
        this.diasVacacionesRestantes = diasVacacionesRestantes;
    }
    public boolean isRequiereCambioContrasena() {
        return requiereCambioContrasena;
    }
    public void setRequiereCambioContrasena(boolean requiereCambioContrasena) {
        this.requiereCambioContrasena = requiereCambioContrasena;
    }


    private void calcularAntiguedad(Date fechaIngreso){

        PGInterval interval = new PGInterval();
        
        if (fechaIngreso == null){
            interval.setDays(0);
            setAntiguedad(interval.toString());
        }

        LocalDate fechaIngresoLocal = fechaIngreso.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate();


        LocalDate hoy = LocalDate.now();

        int dias = (int) ChronoUnit.DAYS.between(fechaIngresoLocal, hoy);
        interval.setDays(dias);
        setAntiguedad(interval.toString());
    }
}

