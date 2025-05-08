package pe.edu.upc.desiclothapi.servicesinterfaces;
import pe.edu.upc.desiclothapi.entities.Pago;
import java.util.List;

public interface IPagoService {

    public List<Pago> listPago();
    //HU-PAG-17
    public void insertPago(Pago pa);
    //HU-PAG-15
    public List<Pago> searchByUsuario (int idUser);



}
