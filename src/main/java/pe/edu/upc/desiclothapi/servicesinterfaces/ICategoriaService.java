package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Categoria;

import java.util.List;

public interface ICategoriaService {
    public List<Categoria> listCategoria(); //HU-CAT-29
    public void insertCategoria(Categoria c); //HU-CAT-31
    public void updateCategoria(Categoria c); //HU-CAT-32
    public void deleteCategoria(int id); //HU-CAT-33
    List<Categoria> ordenarAZ(); //HU-CAT-34-01
    List<Categoria> ordenarZA(); //HU-CAT-34-02
    public List<Categoria> searchCategoria(String nombreC); //HU-CAT-30
}
