package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.DetallePedido;

import java.util.List;

public interface IDetallePedidoService {
    public List<DetallePedido> listDetallePedido();
    public void insertDetallePedido(DetallePedido dp);
    public void updateDetallePedido(DetallePedido dp);
    public void deleteDetallePedido(int id);
}
