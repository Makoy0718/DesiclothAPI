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


    //HU-REC-10
    @Query("SELECT r.users.id AS userId, r.users.username AS username, r.users.correoUser AS correoUser, COUNT(r) AS totalReclamos\n" +
            "FROM Reclamo r\n" +
            "GROUP BY r.users.id")
    List<Object[]> findReclamosCountByEstadoAndUser();
}
