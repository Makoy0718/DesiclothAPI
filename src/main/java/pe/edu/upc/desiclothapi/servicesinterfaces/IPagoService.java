package pe.edu.upc.desiclothapi.servicesinterfaces;
import pe.edu.upc.desiclothapi.dtos.UsuarioMontoDTO;
import pe.edu.upc.desiclothapi.entities.Pago;

import java.time.LocalDate;
import java.util.List;

public interface IPagoService {

    //buscar-id-pago
    public Pago buscarPagoPorId(int id);

    public void updatePago(Pago p);
    //HU-PAG-54
    public List<Pago> listPago();
    //HU-PAG-17
    public void insertPago(Pago pa);
    //HU-PAG-15
    public List<Pago> searchByUsuario (int idUser);
    //HU-PAG-18
    public void deletePago (int id);

    //HU-PAG-55
    List<Pago> buscarPorMetodoPago(String metodo);
    //HU-PAG-56
    List<Pago> buscarPorFechaPago(LocalDate fecha);
    //HU-PAG-57
    public List<Pago> buscarPagosPorUsuarioYFecha (int idUser, LocalDate fecha);

    //HU-PAG-58
    //List<Object[]> obtenerTotalPagosPorUsuario ();

    //query de top 5 pagos mas altos
    List<Pago> obtenerTop5Pagos();

    //Query para ver cuando de monto hay por usuario
    List<UsuarioMontoDTO> obtenerTotalPagosPorUsuario();





}
