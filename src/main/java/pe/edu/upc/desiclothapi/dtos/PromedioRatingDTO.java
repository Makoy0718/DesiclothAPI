package pe.edu.upc.desiclothapi.dtos;
//HU-GAL--47
public class PromedioRatingDTO {
    private Double promedio;
    private String mensaje;

    public PromedioRatingDTO(Double promedio, String mensaje) {
        this.promedio = promedio;
        this.mensaje = mensaje;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
