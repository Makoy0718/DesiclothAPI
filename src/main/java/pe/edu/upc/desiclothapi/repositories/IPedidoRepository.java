package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.desiclothapi.entities.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
    @Query("select p from Pedido p where p.fechaPedido = :fecha")
    List<Pedido> buscarPorFechaPedido(@Param("fecha") LocalDate fecha);

    //HU-PED-13
    @Query("SELECT p.estadoPedido FROM Pedido p WHERE p.idPedido = :idPedido")
    Boolean obtenerEstadoPorId(@Param("idPedido") int idPedido);

}
