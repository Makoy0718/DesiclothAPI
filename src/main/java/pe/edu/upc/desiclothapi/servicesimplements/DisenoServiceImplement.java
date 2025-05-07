package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Diseno;
import pe.edu.upc.desiclothapi.repositories.IDisenoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IDisenoService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DisenoServiceImplement implements IDisenoService {
    @Autowired
    private IDisenoRepository dR;
    //HU-DIS-20
    @Override
    public void insertDiseno(Diseno d) { dR.save(d); }
    //HU-DIS-25
    @Override
    public List<Diseno> listDiseno() { return dR.findAll(); }
    //HU-DIS-28
    @Override
    public void deleteDiseno(int id) { dR.deleteById(id); }
    //HU-DIS-21
    @Override
    public List<Diseno> searchByGeneroYCategoria(int idGenero, int idCategoria) {
        return dR.buscarPorGeneroYCategoria(idGenero, idCategoria);
    }
    //HU-DIS-22
    @Override
    public List<Diseno> findByFechaOrigenDisenoReciente() {
        LocalDate fechaLimite = LocalDate.now().minusDays(7);
        return dR.buscarDisenosRecientes(fechaLimite);
    }
    //HU-DIS-23
    @Override
    public List<Diseno> findByTipoOrigenDiseno(String tipoOrigenDiseno) {
        return dR.buscarByTipoOrigen(tipoOrigenDiseno);
    }
    //HU-DIS-24
    @Override
    public Diseno findById(int id) {
        return dR.findById(id).orElseThrow(() -> new NoSuchElementException("Diseño no encontrado con ID: " + id));
    }
    //HU-DIS-55
    @Override
    public List<Diseno> findByGeneroId(int idGenero) {
        return dR.buscarPorGenero(idGenero);
    }
    //HU-DIS-56
    @Override
    public List<Diseno> findByCategoriaId(int idCategoria) {
        return dR.buscarPorCategoria(idCategoria);
    }
    //HU-GEN-39
    @Override
    public List<Diseno> findByGeneroNombre(String n) {
        return dR.buscarPorNombreGenero(n);
    }
}
