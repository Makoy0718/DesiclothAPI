package pe.edu.upc.desiclothapi.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Genero;
import pe.edu.upc.desiclothapi.repositories.IGeneroRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IGeneroService;

import java.util.List;

@Service
public class GeneroServiceImplement implements IGeneroService {

    @Autowired
    public IGeneroRepository gR;


    @Override
    public List<Genero> list() {
        return gR.findAll();
    }

    @Override
    public void insert(Genero g) {
        gR.save(g);
    }

    @Override
    public void update(Genero g) {
        gR.save(g);
    }

    @Override
    public void delete(int id) {
        gR.deleteById(id);
    }

    @Override
    public Genero searchById(int id) {
        return gR.findById(id).orElse(new Genero());
    }
}
