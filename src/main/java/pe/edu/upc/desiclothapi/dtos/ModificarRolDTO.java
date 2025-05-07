package pe.edu.upc.desiclothapi.dtos;

import pe.edu.upc.desiclothapi.entities.Role;

public class ModificarRolDTO {
    private String username;
    private Role rol;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }
}
