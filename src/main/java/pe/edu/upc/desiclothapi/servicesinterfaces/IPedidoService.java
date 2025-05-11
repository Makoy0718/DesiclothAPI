package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Galeria;
import pe.edu.upc.desiclothapi.entities.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface IPedidoService {

    //HU-PED-16
    public List<Pedido> listPedido();

    //buscar-id-pedido
    public Pedido buscarPedidoPorId(int id);


    public void insertPedido(Pedido pe);

    List<Pedido> buscarPorFechaPedido(LocalDate fecha);

    public Boolean obtenerEstadoPorId(int idPedido);



}
