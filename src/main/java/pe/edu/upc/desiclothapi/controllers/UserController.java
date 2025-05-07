package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.UserDTO;
import pe.edu.upc.desiclothapi.entities.User;
import pe.edu.upc.desiclothapi.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private IUserService uS;


    @GetMapping("/verUsusarios")
    public List<UserDTO> listar() {
        return uS.list().stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, UserDTO.class);
        }).collect(Collectors.toList());
    }


    @PostMapping("/registro")
    public void insertar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User u = m.map(dto, User.class);
        uS.insert(u);
    }


    @PutMapping
    public void modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User u = m.map(dto, User.class);
        uS.update(u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        uS.delete(id);
    }

}
