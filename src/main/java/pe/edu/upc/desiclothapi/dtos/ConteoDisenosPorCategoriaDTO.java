package pe.edu.upc.desiclothapi.dtos;

public class ConteoDisenosPorCategoriaDTO {
    private String nombreCategoria;
    private int cantidadDisenos;


    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getCantidadDisenos() {
        return cantidadDisenos;
    }

    public void setCantidadDisenos(int cantidad) {
        this.cantidadDisenos = cantidadDisenos;
    }
}
