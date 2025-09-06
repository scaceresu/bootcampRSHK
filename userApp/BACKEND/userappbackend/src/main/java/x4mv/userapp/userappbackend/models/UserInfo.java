package x4mv.userapp.userappbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UserInfo {
   
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido; 
     @Column(name = "nro_cedula")
    private int nroCedula;
    private String antiguedad;
    private String correo;
    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolModel rol;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private EquipoModel equipo;
    
    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private CargoModel cargo;
    
    @Column(name = "dias_vacaciones")
    private int diasVacaciones;
    @Column(name = "dias_vacaciones_restantes")
    private int diasVacaionesRestante;
    @Column(name = "requiere_cambio_contrasena")
    private boolean requiereCambioContrasena;
    
    
    public UserInfo() {
    }


    public UserInfo(String correo,String nombre, String apellido, int nroCedula, String antiguedad, RolModel rol, EquipoModel equipo,
            CargoModel cargo, int diasVacaciones, int diasVacaionesRestante, boolean requiereCambioContrasena) {
        this.nombre = nombre;        
        this.apellido = apellido;
        this.nroCedula = nroCedula;
        this.antiguedad = antiguedad;
        this.rol = rol;
        this.equipo = equipo;
        this.cargo = cargo;
        this.diasVacaciones = diasVacaciones;
        this.diasVacaionesRestante = diasVacaionesRestante;
        this.requiereCambioContrasena = requiereCambioContrasena;
        this.correo = correo;
    }    

    public int getDiasVacaionesRestante() {
        return diasVacaionesRestante;
    }    

    public void setDiasVacaionesRestante(int diasVacaionesRestante) {
        this.diasVacaionesRestante = diasVacaionesRestante;
    }    

    public boolean getRequiereCambioContrasena() {
        return requiereCambioContrasena;
    }    

    public void setRequiereCambioContrasena(boolean requiereCambioContrasena) {
        this.requiereCambioContrasena = requiereCambioContrasena;
    }        


    public UserInfo(CargoModel cargo) {
        this.cargo = cargo;
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

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public RolModel getRol() {
        return rol;
    }

    public void setRol(RolModel rol) {
        this.rol = rol;
    }

    public EquipoModel getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoModel equipo) {
        this.equipo = equipo;
    }

    public CargoModel getCargo() {
        return cargo;
    }

    public void setCargo(CargoModel cargo) {
        this.cargo = cargo;
    }

    public int getDiasVacaciones() {
        return diasVacaciones;
    }

    public void setDiasVacaciones(int dias_vacaciones) {
        this.diasVacaciones = dias_vacaciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
    
