package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.GeneroDTO;
import pe.edu.upc.desiclothapi.entities.Genero;
import pe.edu.upc.desiclothapi.servicesinterfaces.IGeneroService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private IGeneroService gS;


    @GetMapping("/lista")
    public List<GeneroDTO> listar() {
        return gS.list().stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, GeneroDTO.class);
        }).collect(Collectors.toList());
    }


    @PostMapping("/prueba")
    public void insertar(@RequestBody GeneroDTO dto) {
        ModelMapper m = new ModelMapper();
        Genero g = m.map(dto, Genero.class);
        gS.insert(g);
    }


    @PutMapping
    public void modificar(@RequestBody GeneroDTO dto) {
        ModelMapper m = new ModelMapper();
        Genero g = m.map(dto, Genero.class);
        gS.update(g);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        gS.delete(id);
    }
}
