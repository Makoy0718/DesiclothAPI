package pe.edu.upc.desiclothapi.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(name = "nombreProducto", length = 50,nullable = false, unique = true)
    private String nombreProducto;

    @Column(name= "descripcionProcto", length = 200, nullable = false)
    private String descripcionProducto;

    @Column(name= "tipoProducto", length = 20, nullable = false)
    private String tipoProducto;

    @Column(name = "tallaProducto",length = 3,nullable = false)
    private String tallaProducto;

    @Column(name = "precioProducto",nullable = false)
    private double precioProducto;

public Producto() {

}

public Producto(int idProducto, String nombreProducto,  String descripcionProcto, String tipoProducto, String tallaProducto, double precioProducto) {
    this.idProducto = idProducto;
    this.nombreProducto = nombreProducto;
    this.descripcionProducto = descripcionProcto;
    this.tipoProducto = tipoProducto;
    this.tallaProducto = tallaProducto;
    this.precioProducto = precioProducto;
}

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getTallaProducto() {
        return tallaProducto;
    }

    public void setTallaProducto(String tallaProducto) {
        this.tallaProducto = tallaProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
