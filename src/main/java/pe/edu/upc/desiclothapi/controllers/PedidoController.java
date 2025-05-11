package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.PedidoDTO;
import pe.edu.upc.desiclothapi.entities.Pedido;
import pe.edu.upc.desiclothapi.servicesinterfaces.IPedidoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private IPedidoService pS;

    //buscar-id-pedido
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public PedidoDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PedidoDTO dto = m.map(pS.buscarPedidoPorId(id), PedidoDTO.class);
        return dto;
    }

    //HU-PED-16
    @GetMapping("/listarPedido")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<PedidoDTO> listarPedido() {
        return pS.listPedido().stream().map( w->{
            ModelMapper m=new ModelMapper();
            return m.map(w, PedidoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/insertarPedido")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertarPedido(@RequestBody PedidoDTO dto) {
        ModelMapper m=new ModelMapper();
        Pedido p = m.map(dto, Pedido.class);
        pS.insertPedido(p);

    }

    @GetMapping("/buscarPorFecha")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<PedidoDTO> buscarPorFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return pS.buscarPorFechaPedido(fecha).stream().map(p->{
                ModelMapper m = new ModelMapper();
                return m.map(p, PedidoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/estadoPedido/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public Boolean obtenerEstado(@PathVariable("id")int idPedido) {
        return pS.obtenerEstadoPorId(idPedido);
    }


}
