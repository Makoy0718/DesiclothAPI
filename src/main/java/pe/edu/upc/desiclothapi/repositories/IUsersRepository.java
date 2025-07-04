package pe.edu.upc.desiclothapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.desiclothapi.entities.Users;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {
    public Users findOneByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("SELECT u FROM Users u WHERE u.username = :nombre")
    Users buscarPorNombreUsuario(@Param("nombre") String nombre);
}
