package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.GeneroDTO;
import pe.edu.upc.desiclothapi.dtos.PagoDTO;
import pe.edu.upc.desiclothapi.dtos.UsuarioMontoDTO;
import pe.edu.upc.desiclothapi.entities.Pago;
import pe.edu.upc.desiclothapi.servicesinterfaces.IPagoService;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Pagos")
public class PagoController {
    @Autowired
    private IPagoService paS;


    //Insertar-HU-PAG-17****
    @PostMapping("/insertarPago")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertPago(@RequestBody PagoDTO p) {
        ModelMapper m = new ModelMapper();
        Pago pago = m.map(p, Pago.class);
        paS.insertPago(pago) ;
    }

    //ActualizarPago****
    @PutMapping("/modificarPago")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void actualizarPago(@RequestBody PagoDTO p) {
        ModelMapper m = new ModelMapper();
        Pago pa = m.map(p, Pago.class);
        paS.updatePago(pa);
    }

    //HU-PAG-54*****
    @GetMapping("/listarPago")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<PagoDTO> listarPago() {
        return paS.listPago().stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, PagoDTO.class);
        }).collect(Collectors.toList());
    }

    //HU-PAG-18
    @DeleteMapping("/eliminarPago/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminarPago(@PathVariable("id") int id)
    {paS.deletePago(id);}




    //buscar-id-pago
    @GetMapping("/buscarPago/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public PagoDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PagoDTO dto = m.map(paS.buscarPagoPorId(id), PagoDTO.class);
        return dto;
    }


    //HU-PAG-15
    @GetMapping("/buscarPorUsuario")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<PagoDTO> buscarPorUsuario(@RequestParam int idUsuario) {
        return paS.searchByUsuario(idUsuario).stream().map(w-> {
            ModelMapper m = new ModelMapper();
            return m.map(w, PagoDTO.class);
        }).collect(Collectors.toList());
    }

    //HU-PAG-55
    @GetMapping("/buscarPorMetodo")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<PagoDTO> buscarPorMetodo(@RequestParam String metodo) {
        return paS.buscarPorMetodoPago(metodo).stream().map( p-> {
            ModelMapper m = new ModelMapper();
            return m.map(p, PagoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-PAG-56
    @GetMapping("/buscarPorFecha")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<PagoDTO> buscarPorFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha)
    {
        return paS.buscarPorFechaPago(fecha).stream().map( p-> {
            ModelMapper m = new ModelMapper();
            return m.map(p, PagoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-PAG-57
    @GetMapping("/buscarPorUsuarioYFecha")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<PagoDTO> buscarPorUserYFecha(@RequestParam int idUser, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return paS.buscarPagosPorUsuarioYFecha(idUser , fecha).stream().map( p -> {
            ModelMapper m = new ModelMapper();
            return m.map(p, PagoDTO.class);
        }).collect(Collectors.toList());
    }

    //HU-PAG-58
    @GetMapping("/totalPagosPorUsuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuarioMontoDTO> obtenerTotales(){
        return paS.obtenerTotalPagosPorUsuario().stream().map( p -> {
            String username = (String) p[0];
            Double total = ((Number) p[1]).doubleValue();
            return new UsuarioMontoDTO(username, total);

        }).collect(Collectors.toList());
    }
}


