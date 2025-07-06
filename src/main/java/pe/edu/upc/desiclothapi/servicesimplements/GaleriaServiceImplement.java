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

    @Override
    public void updateGaleria(Galeria g) { gR.save(g); }

    @Override
    public void deleteGaleria(int id) {gR.deleteById(id);}


    //buscar-id-galeria
    @Override
    public Galeria buscarGaleriaPorId(int id) {
        return gR.findById(id).orElse(new Galeria());
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
    //HU-GAL--44
    @Override
    public void valorarGaleria(int idGaleria, int rating) {
        Galeria galeria = gR.findById(idGaleria)
                .orElseThrow(() -> new RuntimeException("Galería no encontrada"));
        galeria.setRatingGaleria(rating);
        gR.save(galeria);

    }
    //HU-GAL--47
    @Override
    public Double obtenerPromedioRatingGaleria(int idGaleria) {
        // Obtiene el promedio de rating directamente en el servicio
        return gR.findAverageRatingByGaleriaId(idGaleria);
    }

    @Override
    public int getTotalGaleriasConIA() {
        return gR.getTotalGaleriasConIA();
    }

    @Override
    public int getTotalGalerias() {
        return gR.findAll().size();
    }

    @Override
    public List<Galeria> searchByNombreUsuario(String nombre) {
        System.out.println("Buscando galerías del usuario: " + nombre);
        return gR.buscarGaleriaPorUsuario(nombre);
    }
}
