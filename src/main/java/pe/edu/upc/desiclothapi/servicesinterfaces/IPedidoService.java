package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface IPedidoService {
    public List<Pedido> listPedido();

    List<Pedido> buscarPorFechaPedido(LocalDate fecha);

}
