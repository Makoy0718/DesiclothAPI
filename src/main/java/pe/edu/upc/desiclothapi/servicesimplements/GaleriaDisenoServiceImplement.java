package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.GaleriaDiseno;
import pe.edu.upc.desiclothapi.repositories.IGaleriaDisenoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IGaleriaDisenoService;

import java.util.List;

@Service
public class GaleriaDisenoServiceImplement implements IGaleriaDisenoService {
    @Autowired
    private IGaleriaDisenoRepository gdR;

    //HU-GADI-# LISTA TODAS LAS CONEXIONES ENTRE GALERIAS Y DISENOS
    @Override
    public List<GaleriaDiseno> listGaleriaDiseno() { return gdR.findAll(); }

    //HU-GADI-# INSERTA UNA CONEXION ENTRE UN DISENO Y UNA GALERIA CON COMENTARIO
    @Override
    public void insertGaleriaDiseno(GaleriaDiseno gd) { gdR.save(gd); }

    //HU-GADI-# MODIFICA UNA CONEXION ENTRE UN DISENO Y UNA GALERIA CON COMENTARIO
    @Override
    public void updateGaleriaDiseno(GaleriaDiseno gd) { gdR.save(gd); }

    //HU-GADI-# ELIMINA UNA CONEXION ENTRE UN DISENO Y UNA GALERIA CON COMENTARIO SEGUN SU ID
    @Override
    public void deleteGaleriaDiseno(int id) { gdR.deleteById(id); }
}
