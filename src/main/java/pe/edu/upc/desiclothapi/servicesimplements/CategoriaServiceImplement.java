package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Categoria;
import pe.edu.upc.desiclothapi.repositories.ICategoriaRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.ICategoriaService;

@Service
public class CategoriaServiceImplement implements ICategoriaService {
    @Autowired
    private ICategoriaRepository cR;
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
}
