package pe.edu.upc.desiclothapi.dtos;

import pe.edu.upc.desiclothapi.entities.Pedido;
import pe.edu.upc.desiclothapi.entities.Producto;


public class DetallePedidoDTO {
    private int idDetallePedido;
    private Producto producto;
    private Pedido pedido;


    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(int idDetallePedido, Pedido pedido, Producto producto) {
        this.idDetallePedido = idDetallePedido;
        this.pedido = pedido;
        this.producto = producto;
    }

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
