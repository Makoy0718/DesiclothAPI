package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<GeneroDTO> listar() {
        return gS.list().stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, GeneroDTO.class);
        }).collect(Collectors.toList());
    }


    @PostMapping("/creacion")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody GeneroDTO dto) {
        ModelMapper m = new ModelMapper();
        Genero g = m.map(dto, Genero.class);
        gS.insert(g);
    }


    @PutMapping("/edicion")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody GeneroDTO dto) {
        ModelMapper m = new ModelMapper();
        Genero g = m.map(dto, Genero.class);
        gS.update(g);
    }

    @GetMapping("/ver/{id}")
    public GeneroDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        GeneroDTO dto = m.map(gS.searchById(id), GeneroDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        gS.delete(id);
    }
}
