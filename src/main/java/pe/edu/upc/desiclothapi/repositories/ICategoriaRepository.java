package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.desiclothapi.entities.Categoria;

import java.util.List;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
    //HU-CAT-34-01
    //Selecciona todas las categorias y las ordena ascendentemente segun su nombre
    @Query("SELECT c FROM Categoria c ORDER BY c.nombreCategoria ASC")
    List<Categoria> ordenarAZ();
    //HU-CAT-34-02 //Selecciona todas las categorias y las ordena descendentemente segun su nombre
    @Query("SELECT c FROM Categoria c ORDER BY c.nombreCategoria DESC")
    List<Categoria> ordenarZA();
    //HU-CAT-30 selecciona desde Categoria el que coincida con nombreCat en nombreCategoria
    @Query("select a from Categoria a where a.nombreCategoria like %:nombreCat%")
    public List<Categoria> buscarCategoria(@Param("nombreCat") String nombreCat);
    //HU-CAT-54 selecciona las categorias(id) de los disenos en Disenos y las cuenta
    //--Separandolas por cantidad y nombre de la categoria
    @Query("SELECT d.categoria.nombreCategoria, COUNT(d.idDiseno) " +
            "FROM Diseno d GROUP BY d.categoria.nombreCategoria")
    List<String[]> contarDisenosPorCategoria();
}
