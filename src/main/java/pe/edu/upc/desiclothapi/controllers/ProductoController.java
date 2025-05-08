package pe.edu.upc.desiclothapi.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.ProductoDTO;
import pe.edu.upc.desiclothapi.entities.Producto;
import pe.edu.upc.desiclothapi.servicesinterfaces.IProductoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Producto")
public class ProductoController {
    @Autowired
    private IProductoService proS;

    @GetMapping("/listaProducto")
    public List<ProductoDTO> listaProducto() {
        return proS.listProducto().stream().map(x ->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertarProducto")
    public void insertarProducto(@RequestBody ProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        Producto p = m.map(dto,Producto.class);
        proS.insertProducto(p);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable("id") int id) { proS.deleteProducto(id); }

    @GetMapping("/buscartipoProducto")
    public List<ProductoDTO> buscarTipoProducto(@RequestParam String tipoProducto) {
        return proS.searchbytipoProducto(tipoProducto).stream().map( y-> {
            ModelMapper m = new ModelMapper();
            return m.map(y,ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscartallaProducto")
    public List<ProductoDTO> buscarTallaProducto(@RequestParam String tallaProducto) {
        return proS.searchbytallaProducto(tallaProducto).stream().map(z->{
            ModelMapper m = new ModelMapper();
            return m.map(z,ProductoDTO.class);
        }).collect(Collectors.toList());
    }
}
