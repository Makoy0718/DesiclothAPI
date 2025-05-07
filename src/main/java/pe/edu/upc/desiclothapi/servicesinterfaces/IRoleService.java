package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> list();
    public void insert(Role r);
    public void update(Role r);

    public void delete(int id);
}
