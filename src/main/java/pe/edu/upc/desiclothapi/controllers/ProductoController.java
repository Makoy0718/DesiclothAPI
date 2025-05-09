package pe.edu.upc.desiclothapi.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.PrecioPromedioporTallaDTO;
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

    //HU-PRO-36 Visualizar producto disponibles
    @GetMapping("/listaProducto")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<ProductoDTO> listaProducto() {
        return proS.listProducto().stream().map(x ->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertarProducto")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertarProducto(@RequestBody ProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        Producto p = m.map(dto,Producto.class);
        proS.insertProducto(p);
    }

    //HU-PRO-38 Eliminar un producto del catalogo
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminarProducto(@PathVariable("id") int id) { proS.deleteProducto(id); }

    //HU-PRO-37 Filtrar producto por tipo o talla
    @GetMapping("/buscartipoProducto")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<ProductoDTO> buscarTipoProducto(@RequestParam String tipoProducto) {
        return proS.searchbytipoProducto(tipoProducto).stream().map( y-> {
            ModelMapper m = new ModelMapper();
            return m.map(y,ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscartallaProducto")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<ProductoDTO> buscarTallaProducto(@RequestParam String tallaProducto) {
        return proS.searchbytallaProducto(tallaProducto).stream().map(z->{
            ModelMapper m = new ModelMapper();
            return m.map(z,ProductoDTO.class);
        }).collect(Collectors.toList());
    }


    @GetMapping("/precioPromedioPorTalla")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<PrecioPromedioporTallaDTO> precioPromedioPorTalla() {
        return proS.promedioPrecioDiseñoPorTalla().stream().map(fila -> {
            String talla = (String) fila[0];
            Double promedio = (Double) fila[1];
            return new PrecioPromedioporTallaDTO(talla, promedio);
        }).collect(Collectors.toList());
    }
}
