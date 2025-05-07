package pe.edu.upc.desiclothapi.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.RoleDTO;
import pe.edu.upc.desiclothapi.entities.Role;
import pe.edu.upc.desiclothapi.servicesinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleService rS;


    @GetMapping("/lista")
    public List<RoleDTO> listar() {
        return rS.list().stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, RoleDTO.class);
        }).collect(Collectors.toList());
    }


    @PostMapping("/prueba")
    public void insertar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto, Role.class);
        rS.insert(r);
    }


    @PutMapping
    public void modificar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto, Role.class);
        rS.update(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }
}
