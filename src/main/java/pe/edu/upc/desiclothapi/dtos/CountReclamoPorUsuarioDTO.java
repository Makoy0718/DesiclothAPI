package pe.edu.upc.desiclothapi.dtos;

public class CountReclamoPorUsuarioDTO {
    private String estado;
    private String usuario;
    private long totalReclamos;

    public CountReclamoPorUsuarioDTO(String estado, String usuario, long totalReclamos) {
        this.estado = estado;
        this.usuario = usuario;
        this.totalReclamos = totalReclamos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public long getTotalReclamos() {
        return totalReclamos;
    }

    public void setTotalReclamos(long totalReclamos) {
        this.totalReclamos = totalReclamos;
    }
}
