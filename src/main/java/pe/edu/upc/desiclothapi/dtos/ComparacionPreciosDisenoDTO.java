package pe.edu.upc.desiclothapi.dtos;

public class ComparacionPreciosDisenoDTO {
    private String origen;
    private double precioPromedio;

    public ComparacionPreciosDisenoDTO() {
    }

    public ComparacionPreciosDisenoDTO(String origen, double precioPromedio) {
        this.origen = origen;
        this.precioPromedio = precioPromedio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public double getPrecioPromedio() {
        return precioPromedio;
    }

    public void setPrecioPromedio(double precioPromedio) {
        this.precioPromedio = precioPromedio;
    }
}
