package pe.edu.upc.desiclothapi.servicesinterfaces;

import pe.edu.upc.desiclothapi.entities.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> listProducto(); //HU-PRO-36 Visualizar producto disponibles
    public Producto searchbyId(int id);
    public void insertProducto(Producto p); //
    public void deleteProducto(int id);
    public List<Producto> searchbytipoProducto(String tipoProducto);
    public List<Producto> searchbytallaProducto(String tipoProducto);
    List<Object[]> promedioPrecioDiseñoPorTalla();


}
