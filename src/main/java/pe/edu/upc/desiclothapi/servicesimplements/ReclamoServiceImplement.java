package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Reclamo;
import pe.edu.upc.desiclothapi.repositories.IReclamoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IReclamoService;

import java.util.List;

@Service
public class ReclamoServiceImplement implements IReclamoService {

    @Autowired
    private IReclamoRepository rR;

    //HU-REC-05
    @Override
    public void insertReclamos(Reclamo r) {
        rR.save(r);
    }

    //HU-REC-05
    @Override
    public List<Reclamo> buscarPorTitulo(String titulo) {
        return rR.buscarPorTitulo(titulo);
    }
}
