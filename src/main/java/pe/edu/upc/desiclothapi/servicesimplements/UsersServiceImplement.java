package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Role;
import pe.edu.upc.desiclothapi.entities.Users;
import pe.edu.upc.desiclothapi.repositories.IRoleRepository;
import pe.edu.upc.desiclothapi.repositories.IUsersRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {

    @Autowired
    public IUsersRepository uR;
    @Autowired
    public IRoleRepository rR;

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Users u) {
        uR.save(u);
    }

    @Override
    public void update(Users u) {
        uR.save(u);
    }

    @Override
    public void updateRole(int id, int idRole) {
        Users u = uR.findById(id).get();
        Role r = rR.findById(idRole).get();
        u.setIdUser(id);
        u.setRol(r);
        uR.save(u);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

}
