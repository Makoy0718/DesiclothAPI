package pe.edu.upc.desiclothapi.dtos;

import jakarta.persistence.*;
import pe.edu.upc.desiclothapi.entities.Diseno;
import pe.edu.upc.desiclothapi.entities.Galeria;

public class GaleriaDisenoDTO {
    private int idGaleriaDiseno;
    private Galeria galeria;
    private Diseno diseno;
    private String comentarios;

    public GaleriaDisenoDTO() {}

    public GaleriaDisenoDTO(int idGaleriaDiseno, Galeria galeria, Diseno diseno, String comentarios) {
        this.idGaleriaDiseno = idGaleriaDiseno;
        this.galeria = galeria;
        this.diseno = diseno;
        this.comentarios = comentarios;
    }

    public int getIdGaleriaDiseno() {
        return idGaleriaDiseno;
    }

    public void setIdGaleriaDiseno(int idGaleriaDiseno) {
        this.idGaleriaDiseno = idGaleriaDiseno;
    }

    public Galeria getGaleria() {
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }

    public Diseno getDiseno() {
        return diseno;
    }

    public void setDiseno(Diseno diseno) {
        this.diseno = diseno;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
