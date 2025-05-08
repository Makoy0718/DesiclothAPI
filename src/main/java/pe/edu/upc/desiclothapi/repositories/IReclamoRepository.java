package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.desiclothapi.entities.Reclamo;

import java.util.List;


@Repository
public interface IReclamoRepository extends JpaRepository<Reclamo, Integer> {

    //HU-REC-06
    @Query("select r from Reclamo r where lower(r.titulo) like lower(concat('%', :titulo, '%'))")
    List<Reclamo> buscarPorTitulo(@Param("titulo") String titulo);
}
