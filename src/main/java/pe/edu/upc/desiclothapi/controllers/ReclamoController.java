package pe.edu.upc.desiclothapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.desiclothapi.dtos.ReclamoDTO;
import pe.edu.upc.desiclothapi.entities.Reclamo;
import pe.edu.upc.desiclothapi.servicesinterfaces.IReclamoService;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {
    @Autowired
    private IReclamoService rS;

    //HU-REC-05
    @PostMapping("/insertarReclamos")
    public void insertarReclamos(@RequestBody ReclamoDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamo r = m.map(dto, Reclamo.class);
        rS.insertReclamos(r);
    }

}
