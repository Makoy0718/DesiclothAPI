package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.desiclothapi.entities.Categoria;

import java.util.List;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
    //HU-CAT-34-01
    @Query("SELECT c FROM Categoria c ORDER BY c.nombreCategoria ASC")
    List<Categoria> ordenarAZ();
    //HU-CAT-34-02
    @Query("SELECT c FROM Categoria c ORDER BY c.nombreCategoria DESC")
    List<Categoria> ordenarZA();
}
