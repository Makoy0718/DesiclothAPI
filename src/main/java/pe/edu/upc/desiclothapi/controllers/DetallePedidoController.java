package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.desiclothapi.dtos.DetallePedidoDTO;

import pe.edu.upc.desiclothapi.entities.DetallePedido;
import pe.edu.upc.desiclothapi.servicesinterfaces.IDetallePedidoService;

import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/DetallePedido")
public class DetallePedidoController {
    @Autowired
    private IDetallePedidoService dpS;

    @GetMapping("/listarDetallePedido")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<DetallePedidoDTO> listarGaleriaDiseno() {
        return dpS.listDetallePedido().stream().map(d->{
            ModelMapper m=new ModelMapper();
            return m.map(d,DetallePedidoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertarDetallePedido")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public void insertarDetallePedido(@RequestBody DetallePedidoDTO dto) {
        ModelMapper m=new ModelMapper();
        DetallePedido dp=m.map(dto,DetallePedido.class);
        dpS.insertDetallePedido(dp);
    }

    @PutMapping("/modificarDetallePedido")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public void modificarDetallePedido(@RequestBody DetallePedidoDTO dto) {
        ModelMapper m=new ModelMapper();
        DetallePedido dp=m.map(dto,DetallePedido.class);
        dpS.updateDetallePedido(dp);
    }

    @DeleteMapping("/eliminarDetallePedido/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public void eliminarDetallePedido(@PathVariable("id")int id) {
        dpS.deleteDetallePedido(id);
    }
}
