package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.ComparacionPreciosDisenoDTO;
import pe.edu.upc.desiclothapi.dtos.ConteoDisenoCategoriaOrigenDTO;
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
    //HU-DIS-23
    @GetMapping("/buscarPorOrigen")
    public List<DisenoDTO> buscarPorOrigen(@RequestParam String tipo) {
        return dS.findByTipoOrigenDiseno(tipo).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-24
    @GetMapping("/detalleDiseno")
    public DisenoDTO detalleDiseno(@RequestParam int id) {
        ModelMapper m = new ModelMapper();
        return m.map(dS.findById(id), DisenoDTO.class);
    }
    //HU-DIS-55
    @GetMapping("/buscarPorGenero")
    public List<DisenoDTO> buscarPorGenero(@RequestParam int idGenero) {
        return dS.findByGeneroId(idGenero).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-56
    @GetMapping("/buscarPorCategoria")
    public List<DisenoDTO> buscarPorCategoria(@RequestParam int idCategoria) {
        return dS.findByCategoriaId(idCategoria).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-GEN-39
    @GetMapping("/buscarPorNombreGenero")
    public List<DisenoDTO> buscarPorNombreGenero(@RequestParam String nombre) {
        return dS.findByGeneroNombre(nombre).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-26
    @GetMapping("/compararPreciosOrigen")
    public List<ComparacionPreciosDisenoDTO> compararPreciosOrigen() {
        return dS.comparePreciosByOrigen().stream().map(fila -> {
            String origen = (String) fila[0];
            Double promedio = (Double) fila[1];
            return new ComparacionPreciosDisenoDTO(origen, promedio);
        }).collect(Collectors.toList());
    }
    //HU-DIS-27
    @GetMapping("/conteoDisenosPorCategoriaYOrigen")
    public List<ConteoDisenoCategoriaOrigenDTO> conteoDisenosPorCategoriaYOrigen() {
        return dS.countDisenosByCategoriaYOrigen().stream().map(fila -> {
            String categoria = (String) fila[0];
            String origen = (String) fila[1];
            Long cantidad = (Long) fila[2];
            return new ConteoDisenoCategoriaOrigenDTO(categoria, origen, cantidad);
        }).collect(Collectors.toList());
    }
}
