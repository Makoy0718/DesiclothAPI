package pe.edu.upc.desiclothapi.dtos;

public class RoleDTO {

    private int idRole;
    private String nombreRole;
    private String descripcionRole;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNombreRole() {
        return nombreRole;
    }

    public void setNombreRole(String nombreRole) {
        this.nombreRole = nombreRole;
    }

    public String getDescripcionRole() {
        return descripcionRole;
    }

    public void setDescripcionRole(String descripcionRole) {
        this.descripcionRole = descripcionRole;
    }
}
