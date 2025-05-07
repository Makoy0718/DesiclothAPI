package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Diseno;

import java.time.LocalDate;
import java.util.List;

public interface IDisenoService {
    public void insertDiseno(Diseno d); //HU-DIS-20
    public List<Diseno> listDiseno(); //HU-DIS-25
    public void deleteDiseno(int id); //HU-DIS-28
    public List<Diseno> searchByGeneroYCategoria(int idGenero, int idCategoria); //HU-DIS-21
    List<Diseno> findByFechaOrigenDisenoReciente(); //HU-DIS-22
    List<Diseno> findByTipoOrigenDiseno(String tipoOrigenDiseno); //HU-DIS-23
    public Diseno findById(int id); //HU-DIS-24
    List<Diseno> findByGeneroId(int idGenero);

}
