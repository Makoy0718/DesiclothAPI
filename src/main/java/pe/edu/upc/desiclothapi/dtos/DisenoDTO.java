package pe.edu.upc.desiclothapi.dtos;

import pe.edu.upc.desiclothapi.entities.Categoria;
import pe.edu.upc.desiclothapi.entities.Genero;
import pe.edu.upc.desiclothapi.entities.Producto;
import pe.edu.upc.desiclothapi.entities.Users;

import java.time.LocalDate;

public class DisenoDTO {
    private int idDiseno;
    private String imagenDiseno;
    private int precioDiseno;
    private LocalDate fechaOrigenDiseno;
    private String tipoOrigenDiseno;
    private String promtDiseno;
    private String respuestaTextoDiseno;
    private Categoria categoria;
    private Genero genero;
    private Producto producto;
    private Users users;

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
