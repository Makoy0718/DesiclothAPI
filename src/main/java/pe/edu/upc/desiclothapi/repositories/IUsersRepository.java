package pe.edu.upc.desiclothapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.desiclothapi.entities.Users;

import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {
    public Users findOneByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select u from Users u where u.username =:username")
    public List<Users> buscarUsername(@Param("username") String nombre);
}
