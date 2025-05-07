package pe.edu.upc.desiclothapi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;
    @Column(name = "metodoPago", length = 50, nullable = false)
    private String metodoPago;

    @Column(name = "montoPago", nullable = false)
    private Double montoPago;
    @Column(name = "comprobantePago", length = 50, nullable = false)
    private String comprobantePago;

    @Column(name = "fechaPago", nullable = false)
    private LocalDate fechaPago;

    @OneToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    public Pago() {
    }

    public Pago(int idPago, String metodoPago, Double montoPago, String comprobantePago, LocalDate fechaPago, Pedido pedido) {
        this.idPago = idPago;
        this.metodoPago = metodoPago;
        this.montoPago = montoPago;
        this.comprobantePago = comprobantePago;
        this.fechaPago = fechaPago;
        this.pedido = pedido;
    }

    public int getIdPago() {return idPago; }
    public void setIdPago(int idPago) { this.idPago = idPago; }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Double montoPago) {
        this.montoPago = montoPago;
    }

    public String getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(String comprobantePago) {
        this.comprobantePago = comprobantePago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
