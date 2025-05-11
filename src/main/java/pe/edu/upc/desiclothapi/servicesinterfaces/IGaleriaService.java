package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Galeria;

import java.util.List;

public interface IGaleriaService {
    public List<Galeria> listGaleria(); //HU-GAL--45
    public void insertGaleria(Galeria g); //HU-GAL--41
    public Galeria buscarGaleriaPorId(int id); //buscar-id-galeria
    public List<Galeria> searchByNombre(String nombre);//HU-GAL--42
    public Galeria cambiarVisibilidadGaleria(int idGaleria, boolean visibilidad);//HU-GAL--43
    public void valorarGaleria(int idGaleria, int rating);//HU-GAL--44
    public Double obtenerPromedioRatingGaleria(int idGaleria);//HU-GAL--47
    public List<String[]> getTotalGaleriasConIA();

}
