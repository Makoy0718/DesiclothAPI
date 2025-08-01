package pe.edu.upc.desiclothapi.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.dtos.UsuarioMontoDTO;
import pe.edu.upc.desiclothapi.entities.Pago;
import pe.edu.upc.desiclothapi.repositories.IPagoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IPagoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PagoServiceImplement implements IPagoService {
    @Autowired
    private IPagoRepository paR;

    //HU-PAG-17
    @Override
    public void insertPago (Pago pa) { paR.save(pa); }

    //*********eliminar
    @Override
    public List<Pago> searchByUsuario(int idUser) {
        return List.of();
    }

    //update
    @Override
    public void updatePago(Pago pa) {
        paR.save(pa);
    }

    //HU-PAG-54
    @Override
    public List<Pago> listPago() {return paR.findAll();}

    //HU-PAG-18
    @Override
    public void deletePago(int id) { paR.deleteById(id); }


    //buscar-id-pago
    @Override
    public Pago buscarPagoPorId(int id) {
        return paR.findById(id).orElse(new Pago ());
    }




    //HU-PAG-55
    @Override
    public List<Pago> buscarPorMetodoPago(String metodo){
        return paR.buscarPorMetodoPago(metodo);
    }

    //HU-PAG-56
    @Override
    public List<Pago> buscarPorFechaPago(LocalDate fecha) {
        return paR.buscarPorFecha(fecha);
    }

    //*****eliminar
    @Override
    public List<Pago> buscarPagosPorUsuarioYFecha(int idUser, LocalDate fecha) {
        return List.of();
    }


    //HU-PAG-58
    //@Override
    //public List<Object[]> obtenerTotalPagosPorUsuario(){
        //return paR.obtenerTotalPagoPorUsuario();
    //}

    //para la querys-top 5 pagos mas altos
    @Override
    public List<Pago> obtenerTop5Pagos(){
        return paR.obtenerTop5pagos();
    }

    //QUERY para ver el total de pago por usuario
    @Override
    public List<UsuarioMontoDTO> obtenerTotalPagosPorUsuario() {
        List<Object[]> lista = paR.obtenerTotalPagoPorUsuario();
        List<UsuarioMontoDTO> listaDTO = new ArrayList<>();
        for (Object[] obj : lista) {
            String nombreUsuario = (String) obj[0];
            Double totalPagado = (Double) obj[1];
            listaDTO.add(new UsuarioMontoDTO(nombreUsuario, totalPagado));
        }
        return listaDTO;
    }
}
