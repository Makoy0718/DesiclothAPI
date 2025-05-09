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
    //HU-DIS-21
    @Query("SELECT d FROM Diseno d WHERE d.genero.idGenero = :idGenero AND d.categoria.idCategoria = :idCategoria")
    List<Diseno> buscarPorGeneroYCategoria(@Param("idGenero") int idGenero, @Param("idCategoria") int idCategoria);
    //HU-DIS-22
    @Query("SELECT d FROM Diseno d WHERE d.fechaOrigenDiseno >= :fechaLimite")
    List<Diseno> buscarDisenosRecientes(@Param("fechaLimite") LocalDate fechaLimite);
    //HU-DIS-23
    @Query("SELECT d FROM Diseno d WHERE d.tipoOrigenDiseno = :tipo")
    List<Diseno> buscarByTipoOrigen(@Param("tipo") String tipo);
    //HU-DIS-55
    @Query("SELECT d FROM Diseno d WHERE d.genero.idGenero = :idGenero")
    List<Diseno> buscarPorGenero(@Param("idGenero") int idGenero);
    //HU-DIS-56
    @Query("SELECT d FROM Diseno d WHERE d.categoria.idCategoria = :idCategoria")
    List<Diseno> buscarPorCategoria(@Param("idCategoria") int idCategoria);
    //HU-GEN-39
    @Query("SELECT d FROM Diseno d WHERE d.genero.nombreGenero = :nombreGenero")
    public List<Diseno> buscarPorNombreGenero(@Param("nombreGenero") String nombreGenero);
    //HU-DIS-26
    @Query("SELECT d.tipoOrigenDiseno, AVG(d.precioDiseno) FROM Diseno d GROUP BY d.tipoOrigenDiseno")
    List<Object[]> compararPreciosPorOrigen();
    //HU-DIS-27
    @Query("SELECT d.categoria.nombreCategoria, d.tipoOrigenDiseno, COUNT(d) " +
            "FROM Diseno d GROUP BY d.categoria.nombreCategoria, d.tipoOrigenDiseno")
    List<Object[]> contarDisenosPorCategoriaYOrigen();
}
