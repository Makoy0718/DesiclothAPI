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
    @Query("SELECT d FROM Diseno d WHERE d.genero = :idGenero AND d.categoria = :idCategoria")
    List<Diseno> buscarPorGeneroYCategoria(@Param("idGenero") int idGenero, @Param("idCategoria") int idCategoria);
    //HU-DIS-22
    @Query("SELECT d FROM Diseno d WHERE d.fechaOrigenDiseno >= :fechaLimite")
    List<Diseno> buscarDisenosRecientes(@Param("fechaLimite") LocalDate fechaLimite);
    //HU-DIS-23
    @Query("SELECT d FROM Diseno d WHERE d.tipoOrigenDiseno = :tipo")
    List<Diseno> buscarByTipoOrigen(@Param("tipo") String tipo);
}
