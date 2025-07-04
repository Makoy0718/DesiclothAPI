package pe.edu.upc.desiclothapi.dtos;

import pe.edu.upc.desiclothapi.entities.Pedido;

import java.time.LocalDate;

public class PagoDTO {
    private int idPago;
    private String metodoPago;
    private Double montoPago;
    private String comprobantePago;
    private LocalDate fechaPago;
    private Pedido pedido;

    public PagoDTO() {
    }

    public PagoDTO(LocalDate fechaPago, Double montoPago, String metodoPago, int idPago, String comprobantePago, Pedido pedido) {
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
        this.metodoPago = metodoPago;
        this.idPago = idPago;
        this.comprobantePago = comprobantePago;
        this.pedido = pedido;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

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
