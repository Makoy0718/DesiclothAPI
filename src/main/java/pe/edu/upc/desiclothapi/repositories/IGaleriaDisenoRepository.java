package pe.edu.upc.desiclothapi.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.desiclothapi.entities.GaleriaDiseno;

@Repository
public interface IGaleriaDisenoRepository extends JpaRepository<GaleriaDiseno, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM GaleriaDiseno gd WHERE gd.diseno.idDiseno = :idDiseno")
    void deleteByDisenoId(@Param("idDiseno") int idDiseno);
}
