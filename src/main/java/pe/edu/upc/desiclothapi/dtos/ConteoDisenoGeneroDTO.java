package pe.edu.upc.desiclothapi.dtos;

public class ConteoDisenoGeneroDTO {
    private String nombreGenero;
    private long cantidadDisenos;

    public ConteoDisenoGeneroDTO(String nombreGenero, long cantidadDisenos) {
        this.nombreGenero = nombreGenero;
        this.cantidadDisenos = cantidadDisenos;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreCategoria) {
        this.nombreGenero = nombreCategoria;
    }

    public long getCantidadDisenos() {
        return cantidadDisenos;
    }

    public void setCantidadDisenos(long cantidadDisenos) {
        this.cantidadDisenos = cantidadDisenos;
    }
}
