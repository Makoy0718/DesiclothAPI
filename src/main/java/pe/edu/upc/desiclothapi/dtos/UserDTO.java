package pe.edu.upc.desiclothapi.dtos;

import pe.edu.upc.desiclothapi.entities.Galeria;
import pe.edu.upc.desiclothapi.entities.Role;

public class UserDTO {
    private int id;
    private String username;
    private String correoUser;
    private String password;
    private Role rol;
    private Galeria galeria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Galeria getGaleria() {
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }
}
