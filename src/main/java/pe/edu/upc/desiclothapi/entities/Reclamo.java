package pe.edu.upc.desiclothapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Reclamo")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReclamo")
    private int idReclamo;

    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Column(name = "estado", length = 200, nullable = false)
    private String estado;

    // Relación ManyToOne con Usuario (un usuario puede hacer muchos reclamos)
    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users users;

    public Reclamo() {
    }

    public Reclamo(int idReclamo, String titulo, String descripcion, String estado, Users users) {
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
