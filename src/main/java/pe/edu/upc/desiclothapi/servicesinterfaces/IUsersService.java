package pe.edu.upc.desiclothapi.servicesinterfaces;


import pe.edu.upc.desiclothapi.entities.Users;

import java.util.List;

public interface IUsersService {
    public List<Users> list();
    public void insert(Users u);
    public void update(Users u);
    public void updateRole(int id, int idRole);
    public void delete(int id);
    public Users searchById(int id);
    public List<Users> searchByUsername(String nombre);
}
