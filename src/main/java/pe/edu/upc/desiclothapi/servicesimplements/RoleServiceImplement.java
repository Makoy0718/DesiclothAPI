package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Role;
import pe.edu.upc.desiclothapi.repositories.IRoleRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {

    @Autowired
    private IRoleRepository rS;

    @Override
    public List<Role> list() {
        return rS.findAll();
    }

    @Override
    public void insert(Role t) {
        rS.save(t);
    }

    @Override
    public void update(Role t) {
        rS.save(t);
    }

    @Override
    public void delete(int id) {
        rS.deleteById(id);
    }

}
