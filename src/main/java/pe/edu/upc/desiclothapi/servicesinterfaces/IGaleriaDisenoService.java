package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Categoria;
import pe.edu.upc.desiclothapi.entities.GaleriaDiseno;

import java.util.List;

public interface IGaleriaDisenoService {
    public List<GaleriaDiseno> listGaleriaDiseno(); //HU-GADI-#
    public void insertGaleriaDiseno(GaleriaDiseno gd); //HU-GADI-#
    public void updateGaleriaDiseno(GaleriaDiseno gd); //HU-GADI-#
    public void deleteGaleriaDiseno(int id); //HU-GADI-#
    public void deleteByDisenoId(int idDiseno);
}
