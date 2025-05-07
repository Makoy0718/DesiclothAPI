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
}
