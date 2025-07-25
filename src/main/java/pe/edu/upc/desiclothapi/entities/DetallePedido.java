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

    public DetallePedido(int idDetallePedido, Pedido pedido, Producto producto) {
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
