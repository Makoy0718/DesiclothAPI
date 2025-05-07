package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Diseno;
import pe.edu.upc.desiclothapi.repositories.IDisenoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IDisenoService;

@Service
public class DisenoServiceImplement implements IDisenoService {
    @Autowired
    private IDisenoRepository dR;

    @Override
    public void insertDiseno(Diseno d) { dR.save(d); }
}
