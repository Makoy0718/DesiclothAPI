package pe.edu.upc.desiclothapi.dtos;
import pe.edu.upc.desiclothapi.entities.Users;
import java.time.LocalDate;

public class PedidoDTO {
    private int idPedido;
    private LocalDate fechaPedido;
    private Boolean estadoPedido;
    private Users users;

    public PedidoDTO() {
    }

    public PedidoDTO(int idPedido, LocalDate fechaPedido, Boolean estadoPedido, Users users) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = estadoPedido;
        this.users = users;
    }

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
