package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.CategoriaDTO;
import pe.edu.upc.desiclothapi.entities.Categoria;
import pe.edu.upc.desiclothapi.servicesinterfaces.ICategoriaService;

@RestController
@RequestMapping("/Categorias")
public class CategoriaController {
    @Autowired
    private ICategoriaService cS;

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
}
