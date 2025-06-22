package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.desiclothapi.entities.Diseno;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDisenoRepository extends JpaRepository<Diseno, Integer> {
    //HU-DIS-21 Selecciona todos los disenos en Diseno siempre y cuando
    //--coincidan con el id del genero y el id de la categoria que se digito
    @Query("SELECT d FROM Diseno d WHERE d.genero.idGenero = :idGenero AND d.categoria.idCategoria = :idCategoria")
    List<Diseno> buscarPorGeneroYCategoria(@Param("idGenero") int idGenero, @Param("idCategoria") int idCategoria);
    //HU-DIS-22 Selecciona todos los disenos en Diseno donde su fechaOrigenDiseno
    //--sea menor o igual a la fechaLiminte establecida
    @Query("SELECT d FROM Diseno d WHERE d.fechaOrigenDiseno >= :fechaLimite")
    List<Diseno> buscarDisenosRecientes(@Param("fechaLimite") LocalDate fechaLimite);
    //HU-DIS-23 Selecciona todos los disenos en Diseno donde su tipoOrigenDiseno
    //--coincida con el tipo que se digito
    @Query("SELECT d FROM Diseno d WHERE d.tipoOrigenDiseno = :tipo")
    List<Diseno> buscarByTipoOrigen(@Param("tipo") String tipo);
    //HU-DIS-55 Selecciona todos los disenos en Diseno donde
    //--coincidan con el id del genero que se digito
    @Query("SELECT d FROM Diseno d WHERE d.genero.idGenero = :idGenero")
    List<Diseno> buscarPorGenero(@Param("idGenero") int idGenero);
    //HU-DIS-56 Selecciona todos los disenos en Diseno donde
    //--coincidan con el id de la categoria que se digito
    @Query("SELECT d FROM Diseno d WHERE d.categoria.idCategoria = :idCategoria")
    List<Diseno> buscarPorCategoria(@Param("idCategoria") int idCategoria);
    //HU-GEN-39 Selecciona todos los disenos en Diseno donde
    //--coincidan con el nombre del genero que se digito
    @Query("SELECT d FROM Diseno d WHERE d.genero.nombreGenero = :nombreGenero")
    public List<Diseno> buscarPorNombreGenero(@Param("nombreGenero") String nombreGenero);
    //HU-DIS-26 Selecciona todos los tipoOrigenDiseno que existan en Diseno
    //--saca el promedio de precioDiseno segun tipoOrigenDiseno
    //--y los agrupa por tipoOrigenDiseno
    @Query("SELECT d.tipoOrigenDiseno, AVG(d.precioDiseno) FROM Diseno d GROUP BY d.tipoOrigenDiseno")
    List<Object[]> compararPreciosPorOrigen();
    //HU-DIS-27 Selecciona todos los categoria que existan en Diseno y usa su nombreCategoria
    //--Selecciona todos los tipoOrigenDiseno que existan en Diseno
    //--y por ultimo realiza un conteo y los agrupa por nombreCategoria y tipoOrigenDiseno
    @Query("SELECT d.categoria.nombreCategoria, d.tipoOrigenDiseno, COUNT(d) " +
            "FROM Diseno d GROUP BY d.categoria.nombreCategoria, d.tipoOrigenDiseno")
    List<Object[]> contarDisenosPorCategoriaYOrigen();
}
