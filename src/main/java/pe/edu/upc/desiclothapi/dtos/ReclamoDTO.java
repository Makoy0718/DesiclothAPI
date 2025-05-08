package pe.edu.upc.desiclothapi.dtos;

import pe.edu.upc.desiclothapi.entities.User;

public class ReclamoDTO {
    private int idReclamo;
    private String titulo;
    private String descripcion;
    private String estado;
    private User user;

    public ReclamoDTO(int idReclamo, String titulo, String descripcion, String estado, User user) {
        this.idReclamo = idReclamo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
