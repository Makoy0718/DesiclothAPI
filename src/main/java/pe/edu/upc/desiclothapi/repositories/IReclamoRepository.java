package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.desiclothapi.entities.Reclamo;

@Repository
public interface IReclamoRepository extends JpaRepository<Reclamo, Integer> {
}
