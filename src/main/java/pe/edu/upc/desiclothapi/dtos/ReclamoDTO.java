package pe.edu.upc.desiclothapi.dtos;

import pe.edu.upc.desiclothapi.entities.Users;

public class ReclamoDTO {
    private int idReclamo;
    private String titulo;
    private String descripcion;
    private String estado;
    private Users users;

    public ReclamoDTO(int idReclamo, String titulo, String descripcion, String estado, Users users) {
        this.idReclamo = idReclamo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.users = users;
    }

    public int getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(int idReclamo) {
        this.idReclamo = idReclamo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }
}
