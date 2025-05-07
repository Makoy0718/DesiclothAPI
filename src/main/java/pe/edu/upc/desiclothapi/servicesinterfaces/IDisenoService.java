package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Diseno;

import java.util.List;

public interface IDisenoService {
    public void insertDiseno(Diseno d); //HU-DIS-20
    public List<Diseno> listDiseno(); //HU-DIS-25
}
