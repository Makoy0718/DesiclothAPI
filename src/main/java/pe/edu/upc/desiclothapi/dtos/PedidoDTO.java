package pe.edu.upc.desiclothapi.dtos;
import pe.edu.upc.desiclothapi.entities.Usuario;
import java.time.LocalDate;

public class PedidoDTO {
    private int idPedido;
    private LocalDate fechaPedido;
    private Boolean estadoPedido;
    private User user;


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Boolean getEstadoPedido() {
        return estadoPedido;
    }


    public void setEstadoPedido(Boolean estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}
