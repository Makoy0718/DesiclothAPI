package pe.edu.upc.desiclothapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "galeria_diseno", uniqueConstraints = { //De lo que investigue se necesita @UniqueConstraint
        @UniqueConstraint(columnNames = {"idGaleria", "idDiseno"}) //Para que una id no pueda tener repetidas estas id al ser compuesta
})
public class GaleriaDiseno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGaleriaDiseno;

    @ManyToOne
    @JoinColumn(name = "idGaleria")
    private Galeria galeria;

    @ManyToOne
    @JoinColumn(name = "idDiseno")
    private Diseno diseno;

    @Column(name = "comentarios", length = 100, nullable = false)
    private String comentarios;

    public GaleriaDiseno() {
    }

    public GaleriaDiseno(int idGaleriaDiseno, Galeria galeria, Diseno diseno, String comentarios) {
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
