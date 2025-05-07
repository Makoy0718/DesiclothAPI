package pe.edu.upc.desiclothapi.dtos;

public class ConteoDisenoCategoriaOrigenDTO {
    private String categoria;
    private String origen;
    private long cantidad;

    public ConteoDisenoCategoriaOrigenDTO(String categoria, String origen, long cantidad) {
        this.categoria = categoria;
        this.origen = origen;
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
}
