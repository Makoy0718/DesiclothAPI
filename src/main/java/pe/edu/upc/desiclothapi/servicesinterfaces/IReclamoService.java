package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Reclamo;

import java.util.List;

public interface IReclamoService {
    public List<Reclamo> listReclamos();//HU-REC-08
    public void insertReclamos(Reclamo r);//HU-REC-05
    public Reclamo buscarReclamoPorId(int id);//buscar-id-reclamo
    List<Reclamo> buscarPorTitulo(String titulo);//HU-REC-06
    public String consultarEstadoReclamo(int idReclamo);//HU-REC-07
    public Reclamo actualizarEstadoReclamo(int idReclamo, String estado);    //HU-REC-09
    List<Object[]> CountReclamosContadosPorEstadoYUsuario();//HU-REC-10
}
