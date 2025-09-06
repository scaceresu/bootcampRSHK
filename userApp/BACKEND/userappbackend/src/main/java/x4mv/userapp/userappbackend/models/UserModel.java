package x4mv.userapp.userappbackend.models;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UserModel {

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
    private String antiguedad;
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
    @Column(name = "dias_vacaciones_restantes")
    private int diasVacacionesRestantes = 30;
    @Column(name = "requiere_cambio_contrasena")
    private boolean requiereCambioContrasena = false;


    public UserModel(){

    }

    public UserModel(String nombre, String apellido, int nroCedula, String correo, Integer idRol, LocalDate fechaIngreso,
            String contrasena, String telefono, Integer idEquipo, Integer idCargo, LocalDate fechaNacimiento) {
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
    
    
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
        calcularDiasVacacionesRestantes(diasVacaciones);
    }
    public boolean getEstado() {
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


private void calcularAntiguedad(LocalDate fechaIngreso) {
    if (fechaIngreso == null) {
        setAntiguedad("0 años 0 meses 0 días");
        return;
    }

    LocalDate hoy = LocalDate.now();

    // Calculamos el período entre la fecha de ingreso y hoy
    Period periodo = Period.between(fechaIngreso, hoy);

    // Formateamos el periodo a un string legible
    setAntiguedad(formatPeriod(periodo));
}

// Método auxiliar para convertir Period a texto legible
private String formatPeriod(Period periodo) {
    StringBuilder sb = new StringBuilder();

    if (periodo.getYears() > 0) {
        sb.append(periodo.getYears()).append(" año");
        if (periodo.getYears() > 1) sb.append("s");
        sb.append(" ");
    }

    if (periodo.getMonths() > 0) {
        sb.append(periodo.getMonths()).append(" mes");
        if (periodo.getMonths() > 1) sb.append("es");
        sb.append(" ");
    }

    if (periodo.getDays() > 0 || sb.isEmpty()) { // mostrar días si no hay años ni meses
        sb.append(periodo.getDays()).append(" día");
        if (periodo.getDays() != 1) sb.append("s");
    }

    return sb.toString().trim();
}


public void calcularDiasVacacionesRestantes(int diasVacas){
    setDiasVacacionesRestantes(Math.max(30 - diasVacas, 0));
}


}

