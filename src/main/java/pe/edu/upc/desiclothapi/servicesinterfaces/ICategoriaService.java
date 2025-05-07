package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Categoria;

public interface ICategoriaService {
    public void insertCategoria(Categoria c); //HU-CAT-31
    public void updateCategoria(Categoria c); //HU-CAT-32
    public void deleteCategoria(int id); //HU-CAT-33
}
