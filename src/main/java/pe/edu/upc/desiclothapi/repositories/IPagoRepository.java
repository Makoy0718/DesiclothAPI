package pe.edu.upc.desiclothapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.desiclothapi.entities.Pago;

import java.time.LocalDate;
import java.util.List;

public interface IPagoRepository extends JpaRepository<Pago, Integer> {

    //HU-PAG-15
    @Query("SELECT p FROM Pago p WHERE p.pedido.user.idUser  = :idUser")
    List<Pago> buscarPagosPorUsuario(@Param("idUsuario") int idUser);

    //HU-PAG-55
    @Query("SELECT p FROM Pago p WHERE p.metodoPago = :metodo")
    List<Pago> buscarPorMetodoPago(@Param("metodo") String metodo);

    //HU-PAG-56
    @Query("SELECT p FROM Pago p WHERE p.fechaPago = :fecha")
    List<Pago> buscarPorFecha(@Param("fecha") LocalDate fecha);

    //HU-PAG-57
    @Query("SELECT p FROM Pago p WHERE p.fechaPago = :fecha AND p.pedido.user.idUser = :idUser")
    List<Pago> buscarPagosPorUsuarioYFecha(@Param("idUser") int idUser, @Param("fecha") LocalDate fecha);





}
