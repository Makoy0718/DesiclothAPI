package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.dtos.ConteoDisenosPorCategoriaDTO;
import pe.edu.upc.desiclothapi.entities.Categoria;
import pe.edu.upc.desiclothapi.repositories.ICategoriaRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.ICategoriaService;

import java.util.List;

@Service
public class CategoriaServiceImplement implements ICategoriaService {
    @Autowired
    private ICategoriaRepository cR;

    //HU-CAT-29 LISTA TODAS LAS CATEGORIAS
    @Override
    public List<Categoria> listCategoria() {
        return cR.findAll();
    }
    //HU-CAT-31 INSERTA UNA CATEGORIA
    @Override
    public void insertCategoria(Categoria c) {
        cR.save(c);
    }
    //HU-CAT-32 MODIFICA UNA CATEGORIA
    @Override
    public void updateCategoria(Categoria c) { cR.save(c); }
    //HU-CAT-33 ELIMINA UNA CATEGORIA EN BASE A ID
    @Override
    public void deleteCategoria(int id) { cR.deleteById(id); }
    //HU-CAT-34-01 ORDENA DE A-Z LAS CATEGORIAS
    @Override
    public List<Categoria> ordenarAZ() {
        return cR.ordenarAZ();
    }
    //HU-CAT-34-02 ORDENA DE Z-A LAS CATEGORIAS
    @Override
    public List<Categoria> ordenarZA() {
        return cR.ordenarZA();
    }
    //HU-CAT-30 BUSCA UNA CATEGORIA POR SU NOMBRE
    @Override
    public List<Categoria> buscarPorNombreCategoria(String c) { return cR.buscarCategoria(c); }
    //HU-CAT-54 CUENTA LA CANTIDAD DE DISENOS POR CADA CATEGORIA
    @Override
    public List<Object[]> contarDisenosPorCategoria() {
        return cR.contarDisenosPorCategoria();
    }

    @Override
    public Categoria buscarPorId(int id) {
        return cR.findById(id).orElse(null);
    }
}
