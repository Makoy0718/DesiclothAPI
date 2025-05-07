package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/listarPedido")
    public List<PedidoDTO> listarPedido() {
        return pS.listPedido().stream().map( w->{
            ModelMapper m=new ModelMapper();
            return m.map(w, PedidoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscarPorFecha")
    public List<PedidoDTO> buscarPorFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return pS.buscarPorFechaPedido(fecha).stream().map(p->{
                ModelMapper m = new ModelMapper();
                return m.map(p, PedidoDTO.class);
        }).collect(Collectors.toList());
    }
}
