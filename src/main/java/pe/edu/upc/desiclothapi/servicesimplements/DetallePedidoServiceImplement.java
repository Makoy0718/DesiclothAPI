package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.DetallePedido;
import pe.edu.upc.desiclothapi.repositories.IDetallePedidoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IDetallePedidoService;

import java.util.List;

@Service
public class DetallePedidoServiceImplement implements IDetallePedidoService {
    @Autowired
    private IDetallePedidoRepository dpR;

    @Override
    public List<DetallePedido> listDetallePedido()
    {
        return dpR.findAll();
    }

    @Override
    public void insertDetallePedido(DetallePedido dp) {
        dpR.save(dp);
    }

    @Override
    public void updateDetallePedido(DetallePedido dp){
        dpR.save(dp);
    }

    @Override
    public void deleteDetallePedido(int id){ dpR.deleteById(id); }
}
