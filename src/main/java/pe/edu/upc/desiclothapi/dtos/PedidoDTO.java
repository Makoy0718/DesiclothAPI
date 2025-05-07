package pe.edu.upc.desiclothapi.dtos;

import java.time.LocalDate;

public class PedidoDTO {
    private int idPedido;
    private LocalDate fechaPedido;
    private Boolean estadoPedido;

    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }

    public Boolean getEstadoPedido() { return estadoPedido; }
    public void setEstadoPedido(Boolean estadoPedido) { this.estadoPedido = estadoPedido; }

    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido;}
}
