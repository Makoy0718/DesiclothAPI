package pe.edu.upc.desiclothapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DetallePedido", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"idProducto","idPedido"})
})
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetallePedido;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido pedido;

    public DetallePedido() {
    }

    public DetallePedido(int idDetallePedido,Producto producto, Pedido pedido) {
        this.idDetallePedido = idDetallePedido;
        this.producto = producto;
        this.pedido = pedido;
    }

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
