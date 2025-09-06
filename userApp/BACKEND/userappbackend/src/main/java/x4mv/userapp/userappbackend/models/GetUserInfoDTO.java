package x4mv.userapp.userappbackend.models;


public class GetUserInfoDTO {
   
    private String nombre; 
    private String apellido;
    private String rolNombre;
    private String cargoNombre;
    private String equipoNombre;
    private int diasVacaciones;
    private int diasVacaionesRestante;
    private boolean requiereCambioContrasena;
    private String antiguedad;
    private int nroCedula;
    private String correo;

    
    public String getAntiguedad() {
        return antiguedad;
    }


    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }


    public GetUserInfoDTO() {
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


    public String getRolNombre() {
        return rolNombre;
    }


    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }


    public String getCargoNombre() {
        return cargoNombre;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public void setCargoNombre(String cargoNombre) {
        this.cargoNombre = cargoNombre;
    }


    public String getEquipoNombre() {
        return equipoNombre;
    }


    public void setEquipoNombre(String equipoNombre) {
        this.equipoNombre = equipoNombre;
    }


    public int getDiasVacaciones() {
        return diasVacaciones;
    }


    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }


    public int getDiasVacaionesRestante() {
        return diasVacaionesRestante;
    }


    public void setDiasVacaionesRestante(int diasVacaionesRestante) {
        this.diasVacaionesRestante = diasVacaionesRestante;
    }


    public boolean isRequiereCambioContrasena() {
        return requiereCambioContrasena;
    }


    public void setRequiereCambioContrasena(boolean requiereCambioContrasena) {
        this.requiereCambioContrasena = requiereCambioContrasena;
    }


    public int getNroCedula() {
        return nroCedula;
    }


    public void setNroCedula(int nroCedula) {
        this.nroCedula = nroCedula;
    }

}