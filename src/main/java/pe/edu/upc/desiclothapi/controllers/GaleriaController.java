package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.GaleriaDTO;
import pe.edu.upc.desiclothapi.entities.Galeria;
import pe.edu.upc.desiclothapi.servicesinterfaces.IGaleriaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Galeria")
public class GaleriaController {
    @Autowired
    private IGaleriaService gS;

    //HU-GAL--45
    @GetMapping("/listarGaleria")
    public List<GaleriaDTO> ListarGalerias() {
        return gS.listGaleria().stream().map(g -> {
            ModelMapper m = new ModelMapper();
            return m.map(g, GaleriaDTO.class);
        }).collect(Collectors.toList());
    }

    //HU-GAL--41
    @PostMapping("/insertarGaleria")
    public void insertarGaleria(@RequestBody GaleriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Galeria g = m.map(dto, Galeria.class);
        gS.insertGaleria(g);
    }

    //HU-GAL--42
    @GetMapping("/buscarPorNombre")
    public List<GaleriaDTO> buscarPorNombre(@RequestParam String nombre) {
        return gS.searchByNombre(nombre).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, GaleriaDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping("/cambiarVisibilidadGaleria/{id}")
    public GaleriaDTO cambiarVisibilidadGaleria(@PathVariable int id, @RequestParam boolean visible) {
        ModelMapper m = new ModelMapper();
        return m.map(gS.cambiarVisibilidadGaleria(id, visible), GaleriaDTO.class);
    }
}
