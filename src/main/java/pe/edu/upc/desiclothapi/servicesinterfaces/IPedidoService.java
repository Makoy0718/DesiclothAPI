package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface IPedidoService {

    public void insertPedido(Pedido pe);
    public void updatePedido(Pedido pe);
    public List<Pedido> listPedido();//HU-PED-16
    public void deletePedido(int id);
    public Pedido findById(int id);

    //public Pedido buscarPedidoPorId(int id);//buscar-id-pedido

    List<Pedido> buscarPorFechaPedido(LocalDate fecha);
    public Boolean obtenerEstadoPorId(int idPedido);

}
