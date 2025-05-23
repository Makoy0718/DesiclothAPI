package pe.edu.upc.desiclothapi.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idRole;

    @Column(name = "nombreRole",length = 50, nullable = false, unique = true)
    private String nombreRole;

    @Column(name = "descripcionRole",length = 500, nullable = false)
    private String descripcionRole;

    public Role() {
    }

    public Role(int idRole, String nombreRole, String descripcionRole) {
        this.idRole = idRole;
        this.nombreRole = nombreRole;
        this.descripcionRole = descripcionRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getDescripcionRole() {
        return descripcionRole;
    }

    public void setDescripcionRole(String descripcionRole) {
        this.descripcionRole = descripcionRole;
    }

    public String getNombreRole() {
        return nombreRole;
    }

    public void setNombreRole(String nombreRole) {
        this.nombreRole = nombreRole;
    }
}

