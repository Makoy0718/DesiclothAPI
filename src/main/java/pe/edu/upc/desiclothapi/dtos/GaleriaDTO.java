package pe.edu.upc.desiclothapi.dtos;

import pe.edu.upc.desiclothapi.entities.GaleriaDiseno;
import pe.edu.upc.desiclothapi.entities.User;

import java.util.List;

public class GaleriaDTO {

    private int idGaleria;
    private String nombreGaleria;
    private boolean visibilidadGaleria;
    private int ratingGaleria;
    private User user;
    private List<GaleriaDiseno> galeriaDisenos;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<GaleriaDiseno> getGaleriaDisenos() {
        return galeriaDisenos;
    }

    public void setGaleriaDisenos(List<GaleriaDiseno> galeriaDisenos) {
        this.galeriaDisenos = galeriaDisenos;
    }
}
