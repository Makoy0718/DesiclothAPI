package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.DisenoDTO;
import pe.edu.upc.desiclothapi.entities.Diseno;
import pe.edu.upc.desiclothapi.servicesinterfaces.IDisenoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Disenos")
public class DisenoController {
    @Autowired
    private IDisenoService dS;

    //HU-DIS-20
    @PostMapping("/insertarDiseno")
    public void insertarDiseno(@RequestBody DisenoDTO dto) {
        ModelMapper m = new ModelMapper();
        Diseno d = m.map(dto, Diseno.class);
        dS.insertDiseno(d);
    }
    //HU-DIS-25
    @GetMapping("/listaDiseno")
    public List<DisenoDTO> listaDiseno() {
        return dS.listDiseno().stream().map(w ->{
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-28
    @DeleteMapping("/{id}")
    public void eliminarDiseno(@PathVariable("id") int id) {
        dS.deleteDiseno(id);
    }
    //HU-DIS-21
    @GetMapping("/buscarPorGeneroYCategoria")
    public List<DisenoDTO> buscarPorGeneroYCategoria(@RequestParam int idGenero, @RequestParam int idCategoria) {
        return dS.searchByGeneroYCategoria(idGenero, idCategoria).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-22
    @GetMapping("/disenosRecientes")
    public List<DisenoDTO> disenosRecientes() {
        return dS.findByFechaOrigenDisenoReciente().stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
}
