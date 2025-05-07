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

    @Override
    public void insertCategoria(Categoria c) {
        cR.save(c);
    }
}
