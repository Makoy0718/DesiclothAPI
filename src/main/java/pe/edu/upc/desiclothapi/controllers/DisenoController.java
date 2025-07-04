package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.CategoriaDTO;
import pe.edu.upc.desiclothapi.dtos.ComparacionPreciosDisenoDTO;
import pe.edu.upc.desiclothapi.dtos.ConteoDisenoCategoriaOrigenDTO;
import pe.edu.upc.desiclothapi.dtos.DisenoDTO;
import pe.edu.upc.desiclothapi.entities.Categoria;
import pe.edu.upc.desiclothapi.entities.Diseno;
import pe.edu.upc.desiclothapi.servicesinterfaces.IDisenoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Disenos")
public class DisenoController {
    @Autowired
    private IDisenoService dS;

    //Anotacion de lo que cada cosa significa dentro del controlador

    //HU-SECCION-# es la historia de usuario a la que se esta referenciando (chequen trello para ver cual es)

    //@Post/Get/DeleteMapping(/ruta) es la anotacion de spring para las peticiones HTTP junto con la ruta que quieres use

    //@PreAuthorize("hasAuthority('ROL','ROL2','ROLn')") es la anotacion de Spring Security para señalar quienes tienen acceso al metodo

    //public/private void/cualquierotracosa nombreMetodo() es el metodo
    //--este puede ser publico o privado y puede retorna nada o algo
    //--al igual que puede tener uno, varios o ningun parametro

    //@RequestBody es que pedira un objeto JSON, "@RequestBody DTO nombreVariable
    //--el ejemplo puesto es el RequestBody que es deserializado automáticamente
    //--en la instancia señalada y luego de ello el nombre de la variable en la que se almacenara

    //@PathVariable("nombreVariableQuePide") tipoDeDato nombreVariable
    //--Pide un solo dato como parametro para utilizar en la ruta
    //--Si es que la ruta es asi @Post/Get/DeleteMapping("/{nombreVariableQuePide}")

    //@RequestParam tipoDeDato nombreVariable pide solo un parametro del tipo especificado

    //ModelMapper m = new ModelMapper(); es una librería que facilita el mapeo entre clases

    //Entidad nombreVariable = m.map(nombreVariableDelRequestBody, Entidad.class);
    //--Se transforma el objeto nombreVariableDelRequestBody en una instancia de la clase Entidad
    //--que es la entidad que se guarda en la base de datos

    //entidadService.metodo() puede pedir o no parametros
    //--llama al método del servicio que encapsula la lógica para realizar la tarea que se le haya programado

    //.stream().map(w -> {} transforma una lista a través de un Stream
    //--para convertir cada entidad a su DTO correspondiente.

    //.collect(Collectors.toList()); recolecta los DTOs convertidos en una lista
    //--que se devuelve como respuesta al cliente.

    //HU-DIS-20
    @PostMapping("/insertarDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public Diseno insertarDiseno(@RequestBody DisenoDTO dto) {
        ModelMapper m = new ModelMapper();
        Diseno d = m.map(dto, Diseno.class);
        return dS.insertDiseno(d);
    }
    //HU-DIS-#
    @PutMapping("/modificarDiseno")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificarDiseno(@RequestBody DisenoDTO dto) {
        ModelMapper m = new ModelMapper();
        Diseno d = m.map(dto, Diseno.class);
        dS.updateDiseno(d);
    }
    //HU-DIS-25
    @GetMapping("/listarDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<DisenoDTO> listaDiseno() {
        return dS.listDiseno().stream().map(w ->{
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-28
    @DeleteMapping("/eliminarDiseno/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminarDiseno(@PathVariable("id") int id) {
        dS.deleteDiseno(id);
    }
    //HU-DIS-21
    @GetMapping("/buscarPorGeneroYCategoriaDiseno")
    public List<DisenoDTO> buscarPorGeneroYCategoria(@RequestParam int idGenero, @RequestParam int idCategoria) {
        return dS.searchByGeneroYCategoria(idGenero, idCategoria).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-22
    @GetMapping("/buscarRecientesDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<DisenoDTO> disenosRecientes() {
        return dS.findByFechaOrigenDisenoReciente().stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-23
    @GetMapping("/buscarPorOrigenDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<DisenoDTO> buscarPorOrigen(@RequestParam String tipo) {
        return dS.findByTipoOrigenDiseno(tipo).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-24
    @GetMapping("/detallarDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public DisenoDTO detalleDiseno(@RequestParam int id) {
        ModelMapper m = new ModelMapper();
        return m.map(dS.findById(id), DisenoDTO.class);
    }
    //HU-DIS-55
    @GetMapping("/buscarPorIDGeneroDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<DisenoDTO> buscarPorGenero(@RequestParam int idGenero) {
        return dS.findByGeneroId(idGenero).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-56
    @GetMapping("/buscarPorIDCategoriaDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<DisenoDTO> buscarPorCategoria(@RequestParam int idCategoria) {
        return dS.findByCategoriaId(idCategoria).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-GEN-39
    @GetMapping("/buscarPorNombreGeneroDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<DisenoDTO> buscarPorNombreGenero(@RequestParam String nombre) {
        return dS.findByGeneroNombre(nombre).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-DIS-26
    @GetMapping("/compararPreciosOrigenDiseno")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ComparacionPreciosDisenoDTO> compararPreciosOrigen() {
        return dS.comparePreciosByOrigen().stream().map(fila -> {
            String origen = (String) fila[0];
            Double promedio = (Double) fila[1];
            return new ComparacionPreciosDisenoDTO(origen, promedio);
        }).collect(Collectors.toList());
    }
    //HU-DIS-27
    @GetMapping("/conteoDisenosPorCategoriaYOrigenDiseno")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ConteoDisenoCategoriaOrigenDTO> conteoDisenosPorCategoriaYOrigen() {
        return dS.countDisenosByCategoriaYOrigen().stream().map(fila -> {
            String categoria = (String) fila[0];
            String origen = (String) fila[1];
            Long cantidad = (Long) fila[2];
            return new ConteoDisenoCategoriaOrigenDTO(categoria, origen, cantidad);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscarPorIDUserDiseno")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public List<DisenoDTO> buscarPorIdUser(@RequestParam int idUser) {
        return dS.findByUserId(idUser).stream().map(w -> {
            ModelMapper m = new ModelMapper();
            return m.map(w, DisenoDTO.class);
        }).collect(Collectors.toList());
    }
}
