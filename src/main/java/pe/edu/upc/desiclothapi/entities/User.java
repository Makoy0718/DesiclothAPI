package pe.edu.upc.desiclothapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "correoUser", length = 50, nullable = false)
    private String correoUser;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Role rol;

    @OneToOne
    @JoinColumn(name = "idGaleria")
    private Galeria galeria;

    public User() {
    }

    public User(int idUser, String username, String correoUser, String password, Role rol, Galeria galeria) {
        this.idUser = idUser;
        this.username = username;
        this.correoUser = correoUser;
        this.password = password;
        this.rol = rol;
        this.galeria = galeria;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreoUser() {
        return correoUser;
    }

    public void setCorreoUser(String correoUser) {
        this.correoUser = correoUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    public Galeria getGaleria() {
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }
}
