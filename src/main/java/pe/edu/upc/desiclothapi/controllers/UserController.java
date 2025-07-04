package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.CategoriaDTO;
import pe.edu.upc.desiclothapi.dtos.UserDTO;
import pe.edu.upc.desiclothapi.dtos.UserResponseDTO;
import pe.edu.upc.desiclothapi.entities.Users;
import pe.edu.upc.desiclothapi.servicesinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private IUsersService uS;


    @GetMapping("/listarUsuarios")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<UserResponseDTO> listar() {
        return uS.list().stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, UserResponseDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertarUsuario")
    public ResponseEntity<UserResponseDTO> insertar(@RequestBody UserDTO dto) {
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        uS.insert(u);
        UserResponseDTO response = m.map(u, UserResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/modificarUsuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        uS.update(u);
    }

    @PutMapping("/{id}/modificarRol")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificarRol(@PathVariable int id, @RequestParam int idRole) {
        uS.updateRole(id, idRole);
    }

    @GetMapping("/buscarUsuario/{id}")
    public UserDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.searchById(id), UserDTO.class);
        return dto;
    }


    @DeleteMapping("/eliminarUsuario/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        uS.delete(id);
    }

    @GetMapping("/buscarPorUsername")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<UserResponseDTO> buscarUsername(@RequestParam String nombre) {
        return uS.searchByUsername(nombre).stream().map(y ->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UserResponseDTO.class);
        }).collect(Collectors.toList());
    }
}
