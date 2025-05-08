package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Galeria;
import pe.edu.upc.desiclothapi.repositories.IGaleriaRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IGaleriaService;

import java.util.List;

@Service
public class GaleriaServiceImplement implements IGaleriaService {

    @Autowired
    private IGaleriaRepository gR;

    //HU-GAL--45
    @Override
    public List<Galeria> listGaleria() {
        return gR.findAll();
    }

    //HU-GAL--41
    @Override
    public void insertGaleria(Galeria g) {
        gR.save(g);
    }

    //HU-GAL--42
    @Override
    public List<Galeria> searchByNombre(String nombre) {
        return gR.buscarPorNombre(nombre);
    }

    @Override
    public Galeria cambiarVisibilidadGaleria(int idGaleria, boolean visibilidad) {
        Galeria galeria = gR.findById(idGaleria)
                .orElseThrow(() -> new RuntimeException("Galería no encontrada"));
        galeria.setVisibilidadGaleria(visibilidad);
        return gR.save(galeria);

    }
}
