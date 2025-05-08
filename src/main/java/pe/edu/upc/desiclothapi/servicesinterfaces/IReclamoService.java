package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Reclamo;

import java.util.List;

public interface IReclamoService {
    public void insertReclamos(Reclamo r);//HU-REC-05
    List<Reclamo> buscarPorTitulo(String titulo);//HU-REC-06
}
