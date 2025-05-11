package pe.edu.upc.desiclothapi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPedido;
    @Column(name = "fechaPedido", nullable = false)
    private LocalDate fechaPedido;
    @Column(name = "estadoPedido", length = 20, nullable = false)
    private Boolean estadoPedido;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users users;

    public Pedido() {
    }

    public Pedido(int idPedido, LocalDate fechaPedido, Boolean estadoPedido, Users users) {
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

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }
}
