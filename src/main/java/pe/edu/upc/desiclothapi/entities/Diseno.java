package pe.edu.upc.desiclothapi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Diseno")
public class Diseno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiseno;

    @Column(name = "imagenDiseno",length = 100,nullable = false)
    private String imagenDiseno;

    @Column(name = "precioDiseno",nullable = false)
    private int precioDiseno;

    @Column(name = "fechaOrigenDiseno",nullable = false)
    private LocalDate fechaOrigenDiseno;

    @Column(name = "tipoOrigenDiseno", length = 20,nullable = false)
    private String tipoOrigenDiseno;

    @Column(name = "promtDiseno",length = 100,nullable = true)
    private String promtDiseno;

    @Column(name = "respuestaTextoDiseno",length = 100,nullable = true)
    private String respuestaTextoDiseno;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idGenero")
    private Genero genero;

    @OneToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users users;

    public Diseno() {
    }

    public Diseno(int idDiseno, String imagenDiseno, int precioDiseno, LocalDate fechaOrigenDiseno, String tipoOrigenDiseno, String promtDiseno, String respuestaTextoDiseno, Categoria categoria, Genero genero, Producto producto, Users users) {
        this.idDiseno = idDiseno;
        this.imagenDiseno = imagenDiseno;
        this.precioDiseno = precioDiseno;
        this.fechaOrigenDiseno = fechaOrigenDiseno;
        this.tipoOrigenDiseno = tipoOrigenDiseno;
        this.promtDiseno = promtDiseno;
        this.respuestaTextoDiseno = respuestaTextoDiseno;
        this.categoria = categoria;
        this.genero = genero;
        this.producto = producto;
        this.users = users;
    }

    public int getIdDiseno() {
        return idDiseno;
    }

    public void setIdDiseno(int idDiseno) {
        this.idDiseno = idDiseno;
    }

    public String getImagenDiseno() {
        return imagenDiseno;
    }

    public void setImagenDiseno(String imagenDiseno) {
        this.imagenDiseno = imagenDiseno;
    }

    public int getPrecioDiseno() {
        return precioDiseno;
    }

    public void setPrecioDiseno(int precioDiseno) {
        this.precioDiseno = precioDiseno;
    }

    public LocalDate getFechaOrigenDiseno() {
        return fechaOrigenDiseno;
    }

    public void setFechaOrigenDiseno(LocalDate fechaOrigenDiseno) {
        this.fechaOrigenDiseno = fechaOrigenDiseno;
    }

    public String getTipoOrigenDiseno() {
        return tipoOrigenDiseno;
    }

    public void setTipoOrigenDiseno(String tipoOrigenDiseno) {
        this.tipoOrigenDiseno = tipoOrigenDiseno;
    }

    public String getPromtDiseno() {
        return promtDiseno;
    }

    public void setPromtDiseno(String promtDiseno) {
        this.promtDiseno = promtDiseno;
    }

    public String getRespuestaTextoDiseno() {
        return respuestaTextoDiseno;
    }

    public void setRespuestaTextoDiseno(String respuestaTextoDiseno) {
        this.respuestaTextoDiseno = respuestaTextoDiseno;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }
}
