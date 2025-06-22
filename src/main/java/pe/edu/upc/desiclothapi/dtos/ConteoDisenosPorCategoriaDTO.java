package pe.edu.upc.desiclothapi.dtos;

public class ConteoDisenosPorCategoriaDTO {
    private int idCategoria;
    private String nombreCategoria;
    private long cantidadDisenos;

    public ConteoDisenosPorCategoriaDTO() {
    }

    public ConteoDisenosPorCategoriaDTO(int idCategoria, String nombreCategoria, long cantidadDisenos) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.cantidadDisenos = cantidadDisenos;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public long getCantidadDisenos() {
        return cantidadDisenos;
    }

    public void setCantidadDisenos(long cantidadDisenos) {
        this.cantidadDisenos = cantidadDisenos;
    }
}
