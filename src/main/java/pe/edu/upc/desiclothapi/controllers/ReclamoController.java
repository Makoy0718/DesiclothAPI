package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.CountReclamoPorUsuarioDTO;
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

    //HU-REC-08
    @GetMapping("/listarReclamos")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<ReclamoDTO> listarReclamos() {
        return  rS.listReclamos().stream().map(w->{
            ModelMapper m = new ModelMapper();
            return m.map(w, ReclamoDTO.class);
        }).collect(Collectors.toList());
    }

    //HU-REC-05
    @PostMapping("/insertarReclamos")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertarReclamos(@RequestBody ReclamoDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamo r = m.map(dto, Reclamo.class);
        rS.insertReclamos(r);
    }

    //buscar-id-reclamo
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ReclamoDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ReclamoDTO dto = m.map(rS.buscarReclamoPorId(id), ReclamoDTO.class);
        return dto;

    }

    //HU-REC-06
    @GetMapping("/buscarPorTitulo")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<ReclamoDTO> buscarPorTitulo(@RequestParam String titulo) {
        return rS.buscarPorTitulo(titulo).stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, ReclamoDTO.class);
        }).collect(Collectors.toList());
    }

    //HU-REC-07
    @GetMapping("/{idReclamo}/estado")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public ReclamoDTO consultarEstadoReclamo(@PathVariable int idReclamo) {
        // Obtener el estado del reclamo desde el servicio
        String estado = rS.consultarEstadoReclamo(idReclamo);
        // Creamos el DTO con la información del reclamo, incluyendo el estado
        return new ReclamoDTO(idReclamo, "Consulta del estado", estado, estado, null);
    }

    //HU-REC-09
    @PutMapping("/{idReclamo}/estado")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public ReclamoDTO actualizarEstadoReclamo(@PathVariable int idReclamo, @RequestParam String estado) {
        // Actualizamos el estado del reclamo
        Reclamo reclamoActualizado = rS.actualizarEstadoReclamo(idReclamo, estado);
        // Devolvemos el DTO con los datos actualizados
        return new ReclamoDTO(reclamoActualizado.getIdReclamo(), reclamoActualizado.getTitulo(),
                reclamoActualizado.getDescripcion(), reclamoActualizado.getEstado(),reclamoActualizado.getUser());
    }

    //HU-REC-10
    @GetMapping("/reclamos-contados")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<CountReclamoPorUsuarioDTO> consultarReclamosContados() {
        return rS.CountReclamosContadosPorEstadoYUsuario().stream().map(fila->{
            String estado = (String) fila[0];
            String usuario = (String) fila[1];
            Long totalReclamos = (Long) fila[2];
            return new CountReclamoPorUsuarioDTO(estado, usuario, totalReclamos);
        }).collect(Collectors.toList());
    }
}
