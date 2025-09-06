package x4mv.userapp.userappbackend.models;

public class AuthResponseDto {
    private String token;
    private String correo;
    private String nombre;

    public AuthResponseDto(UserModel user, String token) {
        this.token = token;
        this.correo = user.getCorreo();
        this.nombre = user.getNombre();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // getters
}
