package pe.edu.upc.desiclothapi.dtos;

public class UsuarioMontoDTO {
    //HU-PAG-58
    private String nombreUsuario;
    private Double totalPagado;

    public UsuarioMontoDTO(String nombreUsuario, Double totalPagado) {
        this.nombreUsuario = nombreUsuario;
        this.totalPagado = totalPagado;
    }

    public UsuarioMontoDTO() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Double getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(Double totalPagado) {
        this.totalPagado = totalPagado;
    }
}
