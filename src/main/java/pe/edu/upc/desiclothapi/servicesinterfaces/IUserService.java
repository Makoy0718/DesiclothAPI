package pe.edu.upc.desiclothapi.servicesinterfaces;


import pe.edu.upc.desiclothapi.entities.User;

import java.util.List;

public interface IUserService {
    public List<User> list();
    public void insert(User u);
    public void update(User u);
    public void delete(int id);
}
