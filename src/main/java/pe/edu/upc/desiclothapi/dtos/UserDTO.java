package pe.edu.upc.desiclothapi.dtos;

import pe.edu.upc.desiclothapi.entities.Galeria;
import pe.edu.upc.desiclothapi.entities.Role;

public class UserDTO {
    private int idUser;
    private String username;
    private String correoUser;
    private String password;
    private Role rol;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreoUser() {
        return correoUser;
    }

    public void setCorreoUser(String correoUser) {
        this.correoUser = correoUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }
}
