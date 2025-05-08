package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.desiclothapi.dtos.GaleriaDTO;
import pe.edu.upc.desiclothapi.dtos.PromedioRatingDTO;
import pe.edu.upc.desiclothapi.dtos.TotalGaleriasConIADTO;
import pe.edu.upc.desiclothapi.entities.Galeria;
import pe.edu.upc.desiclothapi.servicesinterfaces.IGaleriaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Galeria")
public class GaleriaController {
    @Autowired
    private IGaleriaService gS;

    //HU-GAL--45
    @GetMapping("/listarGaleria")
    public List<GaleriaDTO> ListarGalerias() {
        return gS.listGaleria().stream().map(g -> {
            ModelMapper m = new ModelMapper();
            return m.map(g, GaleriaDTO.class);
        }).collect(Collectors.toList());
    }

    //HU-GAL--41
    @PostMapping("/insertarGaleria")
    public void insertarGaleria(@RequestBody GaleriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Galeria g = m.map(dto, Galeria.class);
        gS.insertGaleria(g);
    }

    //HU-GAL--42
    @GetMapping("/buscarPorNombre")
    public List<GaleriaDTO> buscarPorNombre(@RequestParam String nombre) {
        return gS.searchByNombre(nombre).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, GaleriaDTO.class);
        }).collect(Collectors.toList());
    }
    //HU-GAL--43
    @PutMapping("/cambiarVisibilidadGaleria/{id}")
    public GaleriaDTO cambiarVisibilidadGaleria(@PathVariable int id, @RequestParam boolean visible) {
        ModelMapper m = new ModelMapper();
        return m.map(gS.cambiarVisibilidadGaleria(id, visible), GaleriaDTO.class);
    }

    //HU-GAL--44
    @PostMapping("/{idGaleria}/valorar")
    public String valorarGaleria(@PathVariable int idGaleria, @RequestParam int rating) {
        gS.valorarGaleria(idGaleria, rating);
        return "Galería valorada con éxito.";
    }

    //HU-GAL--47
    @GetMapping("/{idGaleria}/rating-promedio")
    public PromedioRatingDTO obtenerRatingPromedio(@PathVariable int idGaleria) {
        // Obtener el promedio desde el servicio
        Double promedio = gS.obtenerPromedioRatingGaleria(idGaleria);
        // Si no hay valoraciones, se devuelve "Sin calificaciones"
        if (promedio == null) {
            return new PromedioRatingDTO(0.0, "Sin calificaciones");
        }
        // Si hay valoraciones, se devuelve el promedio con el mensaje adecuado
        return new PromedioRatingDTO(promedio, String.format("El rating promedio es: %.2f", promedio));
    }

    //HU-GAL-54
    @GetMapping("/ia")
    public List<TotalGaleriasConIADTO> obtenerGaleriasConIA() {
        List<TotalGaleriasConIADTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista=gS.getTotalGaleriasConIA();
        for(String[] columna:filaLista) {
            TotalGaleriasConIADTO dto = new TotalGaleriasConIADTO();
            dto.setTotalGalerias(columna[0]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
