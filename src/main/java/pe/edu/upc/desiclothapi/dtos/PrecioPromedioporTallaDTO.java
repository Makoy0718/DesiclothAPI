package pe.edu.upc.desiclothapi.dtos;

public class PrecioPromedioporTallaDTO {
    private String tallaProducto;
    private double promedioPrecioDiseno;

    public PrecioPromedioporTallaDTO(String tallaProducto, double promedioPrecioDiseno) {
        this.tallaProducto = tallaProducto;
        this.promedioPrecioDiseno = promedioPrecioDiseno;
    }

    public String getTallaProducto() {
        return tallaProducto;
    }

    public void setTallaProducto(String tallaProducto) {
        this.tallaProducto = tallaProducto;
    }

    public double getPromedioPrecioDiseno() {
        return promedioPrecioDiseno;
    }

    public void setPromedioPrecioDiseno(double promedioPrecioDiseno) {
        this.promedioPrecioDiseno = promedioPrecioDiseno;
    }
}
