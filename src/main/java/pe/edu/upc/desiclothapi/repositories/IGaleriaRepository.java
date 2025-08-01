package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.desiclothapi.entities.Galeria;

import java.util.List;

@Repository
public interface IGaleriaRepository extends JpaRepository<Galeria, Integer> {

    //HU-GAL--42
    @Query("select g from Galeria g where g.nombreGaleria like %:nombre%")
    List<Galeria> buscarPorNombre(@Param("nombre") String nombre);

    //HU-GAL--47
    @Query("SELECT AVG(g.ratingGaleria) FROM Galeria g WHERE g.idGaleria = :idGaleria")
    Double findAverageRatingByGaleriaId(@Param("idGaleria") int idGaleria);

    //HU-GAL-54
    @Query(value = "select count(distinct gd.id_galeria) as Total_galerias\n" +
            " from diseno d\n" +
            " join galeria_diseno gd on d.id_diseno = gd.id_diseno\n" +
            " where d.tipo_origen_diseno = 'IA'", nativeQuery = true)
    int getTotalGaleriasConIA();

    //Listar Galerias en base a username
    @Query("select g from Galeria g where g.users.username = :nombre")
    List<Galeria> buscarGaleriaPorUsuario(@Param("nombre") String nombre);

}
