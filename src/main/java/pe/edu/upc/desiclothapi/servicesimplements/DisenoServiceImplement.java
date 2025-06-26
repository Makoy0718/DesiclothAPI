package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Diseno;
import pe.edu.upc.desiclothapi.repositories.IDisenoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IDisenoService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DisenoServiceImplement implements IDisenoService {
    @Autowired
    private IDisenoRepository dR;
    //HU-DIS-20 INSERTAR DISENO
    @Override
    public void insertDiseno(Diseno d) { dR.save(d); }


    //HU-DIS-# ACTUALIZAR DISENO
    @Override
    public void updateDiseno(Diseno d) { dR.save(d); }


    //HU-DIS-25 LISTAR TODOS LOS DISENOS
    @Override
    public List<Diseno> listDiseno() { return dR.findAll(); }


    //HU-DIS-28 ELIMINAR DISENO EN BASE A ID
    @Override
    public void deleteDiseno(int id) { dR.deleteById(id); }



    //HU-DIS-21 FILTRAR LOS DISENOS EN BASE AL GENERO Y A LA CATEGORIA
    @Override
    public List<Diseno> searchByGeneroYCategoria(int idGenero, int idCategoria) {
        return dR.buscarPorGeneroYCategoria(idGenero, idCategoria);
    }
    //HU-DIS-22 VER TODOS LOS DISENOS CREADOS EN UN LAPSO DE 7 DIAS
    @Override
    public List<Diseno> findByFechaOrigenDisenoReciente() {
        LocalDate fechaLimite = LocalDate.now().minusDays(7); //LocalDate.now saca la fecha actual y minusDays le resta dias a la fecha que le hayas dado
        return dR.buscarDisenosRecientes(fechaLimite);
    }
    //HU-DIS-23  FILTRA LOS DISENOS EN BASE AL TIPO DE ORIGEN
    @Override
    public List<Diseno> findByTipoOrigenDiseno(String tipoOrigenDiseno) {
        return dR.buscarByTipoOrigen(tipoOrigenDiseno);
    }
    //HU-DIS-24 ENCUENTRA 1 DISENO EN BASE AL ID
    @Override
    public Diseno findById(int id) {
        //orElseThrow lo que hara es lanzar una respuesta personalizada si no encuentra ninguno
        return dR.findById(id).orElseThrow(() -> new NoSuchElementException("Diseño no encontrado con ID: " + id));
    }
    //HU-DIS-55 FILTRA LOS DISENOS EN BASE AL ID DEL GENERO QUE LE DES
    @Override
    public List<Diseno> findByGeneroId(int idGenero) {
        return dR.buscarPorGenero(idGenero);
    }
    //HU-DIS-56 FILTRA LOS DISENOS EN BASE AL ID DE LA CATEGORIA QUE LE DES
    @Override
    public List<Diseno> findByCategoriaId(int idCategoria) {
        return dR.buscarPorCategoria(idCategoria);
    }
    //HU-GEN-39 FILTRA LOS DISENOS EN BASE AL NOMBRE DEL GENERO QUE LE DES
    @Override
    public List<Diseno> findByGeneroNombre(String n) {
        return dR.buscarPorNombreGenero(n);
    }
    //HU-DIS-26 FILTRA LOS DISENOS EN BASE AL NOMBRE DE LA CATEGORIA QUE LE DES
    @Override
    public List<Object[]> comparePreciosByOrigen() {
        return dR.compararPreciosPorOrigen();
    }
    //HU-DIS-27 TE DA UN CONTEO DE LOS DISENOS SEPARADOS POR CATEGORIA Y ORIGEN
    @Override
    public List<Object[]> countDisenosByCategoriaYOrigen() {
        return dR.contarDisenosPorCategoriaYOrigen();
    }
}
