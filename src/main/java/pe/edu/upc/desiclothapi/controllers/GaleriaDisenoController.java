package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.CategoriaDTO;
import pe.edu.upc.desiclothapi.dtos.DisenoDTO;
import pe.edu.upc.desiclothapi.dtos.GaleriaDTO;
import pe.edu.upc.desiclothapi.dtos.GaleriaDisenoDTO;
import pe.edu.upc.desiclothapi.entities.Categoria;
import pe.edu.upc.desiclothapi.entities.Diseno;
import pe.edu.upc.desiclothapi.entities.GaleriaDiseno;
import pe.edu.upc.desiclothapi.servicesinterfaces.IGaleriaDisenoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/GaleriaDisenos")
public class GaleriaDisenoController {
    @Autowired
    private IGaleriaDisenoService gdS;
    //HU-GADI-#
    @GetMapping("/listarGaleriaDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<GaleriaDisenoDTO> listarGaleriaDisenos() {
        return gdS.listGaleriaDiseno().stream().map(g -> {
            ModelMapper m = new ModelMapper();
            return m.map(g, GaleriaDisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-GADI-#
    @PostMapping("/insertarGaleriaDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public void insertarGaleriaDiseno(@RequestBody GaleriaDisenoDTO dto) {
        ModelMapper m = new ModelMapper();
        GaleriaDiseno gd = m.map(dto, GaleriaDiseno.class);
        gdS.insertGaleriaDiseno(gd);
    }
    //HU-GADI-#
    @PutMapping("/modificarGaleriaDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public void modificarGaleriaDiseno(@RequestBody GaleriaDisenoDTO dto) {
        ModelMapper m = new ModelMapper();
        GaleriaDiseno gd = m.map(dto, GaleriaDiseno.class);
        gdS.updateGaleriaDiseno(gd);
    }
    //HU-CAT-33
    @DeleteMapping("/eliminarGaleriaDiseno/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public void eliminarGaleriaDiseno(@PathVariable("id") int id) { gdS.deleteGaleriaDiseno(id); }

    @DeleteMapping("/eliminarPorDiseno/{idDiseno}")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public void eliminarPorIdDiseno(@PathVariable("idDiseno") int idDiseno) {
        gdS.deleteByDisenoId(idDiseno);
    }
}
