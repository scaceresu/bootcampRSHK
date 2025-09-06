package x4mv.userapp.userappbackend.models;

public class RegisterResponseDTO {
    
    private String correo;
    private String contrasena;
    private String token;


    public RegisterResponseDTO() {
    }


    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    
}
