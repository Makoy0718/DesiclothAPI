package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Pedido;
import pe.edu.upc.desiclothapi.repositories.IPedidoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IPedidoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServiceImplements implements IPedidoService {
    @Autowired
    private IPedidoRepository pR;

    @Override
    public List<Pedido> listPedido() { return pR.findAll();}

    @Override
    public List<Pedido> buscarPorFechaPedido(LocalDate fecha) {
        return pR.buscarPorFechaPedido(fecha);
    }


}
