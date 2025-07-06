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

    //HU-PED-Insertar Diseño
    @Override
    public Pedido insertPedido(Pedido pe) {
        return pR.save(pe);  //devuelve el pedido guardado (con ID autogenerado)
    }

    //se agrego de modificar(actualizar Pedido
    @Override
    public void updatePedido(Pedido pe) {
        pR.save(pe);
    }

    //listar todos los pedidos.HU-PED-16/HU-PED-16-Escn01
    @Override
    public List<Pedido> listPedido() {
        return pR.findAll();
    }

    //HU-PED-Eliminar Pedido
    @Override
    public void deletePedido(int id) {
        pR.deleteById(id);
    }

    //Buscar-id-pedido-buscar un pedido en base al id
    @Override
    public Pedido findById(int id) {
        return pR.findById(id).orElse(new Pedido());
    }

    @Override
    public List<Pedido> buscarPorFechaPedido(LocalDate fecha) {
        return pR.buscarPorFechaPedido(fecha);
    }

    @Override
    public Boolean obtenerEstadoPorId(int idPedido) {
        return pR.obtenerEstadoPorId(idPedido);
    }
}










