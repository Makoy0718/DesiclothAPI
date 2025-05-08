package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Reclamo;
import pe.edu.upc.desiclothapi.repositories.IReclamoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IReclamoService;

@Service
public class ReclamoServiceImplement implements IReclamoService {

    @Autowired
    private IReclamoRepository rR;

    //HU-REC-05
    @Override
    public void insertReclamos(Reclamo r) {
        rR.save(r);
    }
}
