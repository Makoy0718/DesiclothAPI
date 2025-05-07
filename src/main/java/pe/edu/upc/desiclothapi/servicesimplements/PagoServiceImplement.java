package pe.edu.upc.desiclothapi.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Pago;
import pe.edu.upc.desiclothapi.repositories.IPagoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IPagoService;

import java.util.List;

@Service
public class PagoServiceImplement implements IPagoService {
    @Autowired
    private IPagoRepository paR;

    @Override
    public List<Pago> listPago() {return paR.findAll();}

    @Override
    public void insertPago (Pago pa) { paR.save(pa); }

}
