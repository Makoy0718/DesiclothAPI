package pe.edu.upc.desiclothapi.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Pago;
import pe.edu.upc.desiclothapi.repositories.IPagoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IPagoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class PagoServiceImplement implements IPagoService {
    @Autowired
    private IPagoRepository paR;

    //HU-PAG-54
    @Override
    public List<Pago> listPago() {return paR.findAll();}

    //HU-PAG-17
    @Override
    public void insertPago (Pago pa) { paR.save(pa); }

    //HU-PAG-18
    @Override
    public void deletePago(int id) { paR.deleteById(id); }

    //HU-PAG-15
    @Override
    public List<Pago>searchByUsuario(int idUser){
        return paR.buscarPagosPorUsuario(idUser);
    }

    //HU-PAG-55
    @Override
    public List<Pago> buscarPorMetodoPago(String metodo){
        return paR.buscarPorMetodoPago(metodo);
    }

    //HU-PAG-56
    @Override
    public List<Pago> buscarPorFechaPago(LocalDate fecha) {
        return paR.buscarPorFecha(fecha);
    }
    //update
    @Override
    public void updatePago(Pago pa) {
        paR.save(pa);
    }

    //HU-PAG-57
    @Override
    public List<Pago> buscarPagosPorUsuarioYFecha ( int idUser, LocalDate fecha) {
        return paR.buscarPagosPorUsuarioYFecha(idUser, fecha);
    }


}
