package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Categoria;
import pe.edu.upc.desiclothapi.repositories.ICategoriaRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.ICategoriaService;

import java.util.List;

@Service
public class CategoriaServiceImplement implements ICategoriaService {
    @Autowired
    private ICategoriaRepository cR;

    //HU-CAT-29
    @Override
    public List<Categoria> listCategoria() {
        return cR.findAll();
    }
    //HU-CAT-31
    @Override
    public void insertCategoria(Categoria c) {
        cR.save(c);
    }
    //HU-CAT-32
    @Override
    public void updateCategoria(Categoria c) { cR.save(c); }
    //HU-CAT-33
    @Override
    public void deleteCategoria(int id) { cR.deleteById(id); }
    //HU-CAT-34-01
    @Override
    public List<Categoria> ordenarAZ() {
        return cR.ordenarAZ();
    }
    //HU-CAT-34-02
    @Override
    public List<Categoria> ordenarZA() {
        return cR.ordenarZA();
    }
    //HU-CAT-30
    @Override
    public List<Categoria> searchCategoria(String nombreC) {
        return cR.buscarCategoria(nombreC);
    }

    @Override
    public List<String[]> contarDisenosPorCategoria() {
        return cR.contarDisenosPorCategoria();
    }
}
