package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.PagoDTO;
import pe.edu.upc.desiclothapi.entities.Pago;
import pe.edu.upc.desiclothapi.servicesinterfaces.IPagoService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    @Autowired
    private IPagoService paS;

    //Listar
    @GetMapping("/listaPago")
    public List<PagoDTO> listarPago() {
        return paS.listPago().stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, PagoDTO.class);
        }).collect(Collectors.toList());
    }
    //Insertar
    @PostMapping("/insertarPago")
    public void insertPago(@RequestBody PagoDTO p) {
        ModelMapper m = new ModelMapper();
        Pago pago = m.map(p, Pago.class);
        paS.insertPago(pago);
    }
    //HU-PAG-15
    @GetMapping("/buscarPorUsuario")
    public List<PagoDTO> buscarPorUsuario(@RequestParam int idUsuario) {
        return paS.searchByUsuario(idUsuario).stream().map(w-> {
            ModelMapper m = new ModelMapper();
            return m.map(w, PagoDTO.class);
        }).collect(Collectors.toList());
    }
}


