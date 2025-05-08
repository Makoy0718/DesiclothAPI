package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.CategoriaDTO;
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
    @GetMapping("/listaCategoria")
    public List<Categoria> listaCategoria() {
        return cS.listCategoria().stream().map(w->{
            ModelMapper m = new ModelMapper();
            return m.map(w, Categoria.class);
        }).collect(Collectors.toList());
    }
    //HU-CAT-31
    @PostMapping("/insertarCategoria")
    public void insertarCategoria(@RequestBody CategoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Categoria c = m.map(dto, Categoria.class);
        cS.insertCategoria(c);
    }
    //HU-CAT-32
    @PutMapping("/modificarCategoria")
    public void modificarCategoria(@RequestBody CategoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Categoria c = m.map(dto, Categoria.class);
        cS.updateCategoria(c);
    }
    //HU-CAT-33
    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable("id") int id) { cS.deleteCategoria(id); }
    //HU-CAT-34-01
    @GetMapping("/categoriasOrdenAZ")
    public List<CategoriaDTO> categoriasOrdenAZ() {
        return cS.ordenarAZ().stream().map(c -> {
            ModelMapper m = new ModelMapper();
            return m.map(c, CategoriaDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-CAT-34-02
    @GetMapping("/categoriasOrdenZA")
    public List<CategoriaDTO> categoriasOrdenZA() {
        return cS.ordenarZA().stream().map(c -> {
            ModelMapper m = new ModelMapper();
            return m.map(c, CategoriaDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-CAT-30
    @GetMapping("/nombresC")
    public List<CategoriaDTO> buscarCategoriaNombre(@RequestParam String nombreC) {
        return cS.searchCategoria(nombreC).stream().map(y ->{
            ModelMapper m = new ModelMapper();
            return m.map(y,CategoriaDTO.class);
        }).collect(Collectors.toList());
    }
}
