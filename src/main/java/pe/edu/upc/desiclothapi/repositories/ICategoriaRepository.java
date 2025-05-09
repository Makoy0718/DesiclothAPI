package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.desiclothapi.entities.Categoria;

import java.util.List;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
    //HU-CAT-34-01
    @Query("SELECT c FROM Categoria c ORDER BY c.nombreCategoria ASC")
    List<Categoria> ordenarAZ();
    //HU-CAT-34-02
    @Query("SELECT c FROM Categoria c ORDER BY c.nombreCategoria DESC")
    List<Categoria> ordenarZA();
    //HU-CAT-30
    @Query("select a from Categoria a where a.nombreCategoria like %:nombreC%")
    public List<Categoria> buscarCategoria(@Param("nombreC") String nombreC);
    //HU-CAT-54
    @Query("SELECT d.categoria.nombreCategoria, COUNT(d.idDiseno) " +
            "FROM Diseno d GROUP BY d.categoria.nombreCategoria")
    List<String[]> contarDisenosPorCategoria();
}
