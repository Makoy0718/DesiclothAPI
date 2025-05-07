package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.desiclothapi.entities.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
}
