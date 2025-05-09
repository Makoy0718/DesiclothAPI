package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.desiclothapi.entities.Pago;

import java.time.LocalDate;
import java.util.List;

public interface IPagoRepository extends JpaRepository<Pago, Integer> {

    //HU-PAG-15
    @Query("SELECT p FROM Pago p WHERE p.pedido.users.id  = :idUser")
    List<Pago> buscarPagosPorUsuario(@Param("idUsuario") int idUser);

    //HU-PAG-55
    @Query("SELECT p FROM Pago p WHERE p.metodoPago = :metodo")
    List<Pago> buscarPorMetodoPago(@Param("metodo") String metodo);

    //HU-PAG-56
    @Query("SELECT p FROM Pago p WHERE p.fechaPago = :fecha")
    List<Pago> buscarPorFecha(@Param("fecha") LocalDate fecha);

    //HU-PAG-57
    @Query("SELECT p FROM Pago p WHERE p.fechaPago = :fecha AND p.pedido.users.id = :idUser")
    List<Pago> buscarPagosPorUsuarioYFecha(@Param("idUser") int idUser, @Param("fecha") LocalDate fecha);

    //HU-PAG-58
    @Query(value = "select u.username AS nombreUsuario, SUM (p.monto_pago) AS totalPagado " +
    "from pago p \n" +
    "join pedido ped on p.id_pedido = ped.id_pedido \n" +
    "join user u on ped.id_user = u.id_user \n" +
    " GROUP BY u.username" , nativeQuery = true)
    List<Object[]> obtenerTotalPagoPorUsuario();





}
