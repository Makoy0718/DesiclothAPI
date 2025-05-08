package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.ReclamoDTO;
import pe.edu.upc.desiclothapi.entities.Reclamo;
import pe.edu.upc.desiclothapi.servicesinterfaces.IReclamoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {
    @Autowired
    private IReclamoService rS;

    //HU-REC-05
    @PostMapping("/insertarReclamos")
    public void insertarReclamos(@RequestBody ReclamoDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamo r = m.map(dto, Reclamo.class);
        rS.insertReclamos(r);
    }

    //HU-REC-06
    @GetMapping("/buscarPorTitulo")
    public List<ReclamoDTO> buscarPorTitulo(@RequestParam String titulo) {
        return rS.buscarPorTitulo(titulo).stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, ReclamoDTO.class);
        }).collect(Collectors.toList());
    }

}
