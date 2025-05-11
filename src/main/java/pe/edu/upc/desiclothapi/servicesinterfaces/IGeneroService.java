package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Genero;

import java.util.List;

public interface IGeneroService {
    public List<Genero> list();
    public void insert(Genero g);
    public void update(Genero g);
    public void delete(int id);
    public Genero searchById(int id);
}
