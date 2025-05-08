package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.desiclothapi.entities.Producto;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto,Integer> {
    @Query("SELECT p FROM Producto p WHERE p.tipoProducto like %:tipoP%")
    public List<Producto> buscarTipoProducto(@Param("tipoP") String tipoP);
    @Query("select r FROM Producto r WHERE r.tallaProducto like %:tallaP%")
    public List<Producto>  buscarTallaProducto(@Param("tallaP") String tallaP);
}
