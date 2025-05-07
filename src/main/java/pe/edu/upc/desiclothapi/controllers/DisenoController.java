package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.desiclothapi.dtos.DisenoDTO;
import pe.edu.upc.desiclothapi.entities.Diseno;
import pe.edu.upc.desiclothapi.servicesinterfaces.IDisenoService;

@RestController
@RequestMapping("/Disenos")
public class DisenoController {
    @Autowired
    private IDisenoService dS;

    //Insertar
    @PostMapping("/insertarDiseno")
    public void insertarDiseno(@RequestBody DisenoDTO dto) {
        ModelMapper m = new ModelMapper();
        Diseno d = m.map(dto, Diseno.class);
        dS.insertDiseno(d);
    }
}
