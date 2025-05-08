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

    //HU-REC-08
    @Override
    public List<Reclamo> listReclamos() {
        return rR.findAll();
    }

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

    //HU-REC-07
    @Override
    public String consultarEstadoReclamo(int idReclamo) {
        Reclamo reclamo = rR.findById(idReclamo)
                .orElseThrow(() -> new RuntimeException("Reclamo no encontrado"));
        // Solo devolvemos el estado del reclamo
        return reclamo.getEstado();
    }
}
