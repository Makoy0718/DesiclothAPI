package pe.edu.upc.desiclothapi.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.desiclothapi.entities.Producto;
import pe.edu.upc.desiclothapi.repositories.IDisenoRepository;
import pe.edu.upc.desiclothapi.repositories.IProductoRepository;
import pe.edu.upc.desiclothapi.servicesinterfaces.IProductoService;

import java.util.List;

@Service
public class ProductoServiceImplement implements IProductoService {
    @Autowired
    private IProductoRepository proR;

    @Override
    public List<Producto> listProducto() { return proR.findAll(); }

    @Override
    public void insertProducto(Producto p) {proR.save(p);}

    @Override
    public void deleteProducto(int id) {proR.deleteById(id);}

    @Override
    public List<Producto> searchbytipoProducto(String tipoProducto) { return proR.buscarTipoProducto(tipoProducto);}

    @Override
    public List<Producto> searchbytallaProducto(String tallaProducto) {return proR.buscarTallaProducto(tallaProducto);}

    @Override
    public List<Object[]> promedioPrecioDiseñoPorTalla() {
        return proR.promedioPrecioDiseñoPorTalla();
    }
}
