package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Pago;

import java.util.List;

public interface IPagoService {

    public List<Pago> listPago();
    public void insertPago(Pago pa);

}
