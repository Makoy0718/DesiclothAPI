package pe.edu.upc.desiclothapi.dtos;

public class ProductoDTO {
    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String tipoProducto;
    private String tallaProducto;
    private double precioProdcuto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getTallaProducto() {
        return tallaProducto;
    }

    public void setTallaProducto(String tallaProducto) {
        this.tallaProducto = tallaProducto;
    }

    public double getPrecioProdcuto() {
        return precioProdcuto;
    }

    public void setPrecioProdcuto(double precioProdcuto) {
        this.precioProdcuto = precioProdcuto;
    }
}
