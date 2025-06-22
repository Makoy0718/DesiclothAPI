package pe.edu.upc.desiclothapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGenero;

    @Column(name = "nombreGenero", length = 50, nullable = false, unique = true)
    private String nombreGenero;

    @Column(name = "descripcionGenero", length = 50, nullable = false)
    private String descripcionGenero;

    public Genero() {
    }

    public Genero(int idGenero, String nombreGenero, String descripcionGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
        this.descripcionGenero = descripcionGenero;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public String getDescripcionGenero() {
        return descripcionGenero;
    }

    public void setDescripcionGenero(String descripcionGenero) {
        this.descripcionGenero = descripcionGenero;
    }
}
