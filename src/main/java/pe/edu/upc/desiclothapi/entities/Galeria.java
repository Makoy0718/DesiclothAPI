package pe.edu.upc.desiclothapi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Galeria")
public class Galeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGaleria")
    private int idGaleria;

    @Column(name = "nombreGaleria", length = 50, nullable = false)
    private String nombreGaleria;

    @Column(name = "visibilidadGaleria", nullable = false)
    private boolean visibilidadGaleria;

    @Column(name = "ratingGaleria")
    private int ratingGaleria;

    // Relación ManyToOne con Usuario (un usuario puede hacer muchos reclamos)
    @ManyToOne
    @JoinColumn(name = "id")
    private Users users;

    public Galeria() {
    }

    public Galeria(int idGaleria, String nombreGaleria, boolean visibilidadGaleria, int ratingGaleria) {
        this.idGaleria = idGaleria;
        this.nombreGaleria = nombreGaleria;
        this.visibilidadGaleria = visibilidadGaleria;
        this.ratingGaleria = ratingGaleria;
    }

    public int getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }

    public String getNombreGaleria() {
        return nombreGaleria;
    }

    public void setNombreGaleria(String nombreGaleria) {
        this.nombreGaleria = nombreGaleria;
    }

    public boolean isVisibilidadGaleria() {
        return visibilidadGaleria;
    }

    public void setVisibilidadGaleria(boolean visibilidadGaleria) {
        this.visibilidadGaleria = visibilidadGaleria;
    }

    public int getRatingGaleria() {
        return ratingGaleria;
    }

    public void setRatingGaleria(int ratingGaleria) {
        this.ratingGaleria = ratingGaleria;
    }
}
