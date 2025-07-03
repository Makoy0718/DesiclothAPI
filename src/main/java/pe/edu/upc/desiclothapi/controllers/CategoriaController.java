package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.CategoriaDTO;
import pe.edu.upc.desiclothapi.dtos.ConteoDisenosPorCategoriaDTO;
import pe.edu.upc.desiclothapi.entities.Categoria;
import pe.edu.upc.desiclothapi.servicesinterfaces.ICategoriaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Categorias")
public class CategoriaController {
    @Autowired
    private ICategoriaService cS;

    //HU-CAT-29
    @GetMapping("/listarCategoria")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<Categoria> listaCategoria() {
        return cS.listCategoria().stream().map(w->{
            ModelMapper m = new ModelMapper();
            return m.map(w, Categoria.class);
        }).collect(Collectors.toList());
    }
    //HU-CAT-31
    @PostMapping("/insertarCategoria")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertarCategoria(@RequestBody CategoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Categoria c = m.map(dto, Categoria.class);
        cS.insertCategoria(c);
    }
    //HU-CAT-32
    @PutMapping("/modificarCategoria")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificarCategoria(@RequestBody CategoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Categoria c = m.map(dto, Categoria.class);
        cS.updateCategoria(c);
    }
    //HU-CAT-33
    @DeleteMapping("/eliminarCategoria/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminarCategoria(@PathVariable("id") int id) { cS.deleteCategoria(id); }

    //HU-CAT-34-01
    @GetMapping("/ordenarAZCategoria")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<CategoriaDTO> categoriasOrdenAZ() {
        return cS.ordenarAZ().stream().map(c -> {
            ModelMapper m = new ModelMapper();
            return m.map(c, CategoriaDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-CAT-34-02
    @GetMapping("/ordenarZACategoria")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<CategoriaDTO> categoriasOrdenZA() {
        return cS.ordenarZA().stream().map(c -> {
            ModelMapper m = new ModelMapper();
            return m.map(c, CategoriaDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-CAT-30
    @GetMapping("/buscarPorNombreCategoría")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<CategoriaDTO> buscarCategoriaNombre(@RequestParam String c) {
        return cS.buscarPorNombreCategoria(c).stream().map(y ->{
            ModelMapper m = new ModelMapper();
            return m.map(y,CategoriaDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-CAT-54
    @GetMapping("/contarDisenos")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ConteoDisenosPorCategoriaDTO> obtenerConteoDisenos() {
        return cS.contarDisenosPorCategoria();
    }

    //HU-CAT-35
    @GetMapping("/buscarCategoria/{id}")
    public CategoriaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        CategoriaDTO dto = m.map(cS.buscarPorId(id), CategoriaDTO.class);
        return dto;
    }
}
