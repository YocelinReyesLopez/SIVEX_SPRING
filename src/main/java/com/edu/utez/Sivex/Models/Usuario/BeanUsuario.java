package com.edu.utez.Sivex.Models.Usuario;

import com.edu.utez.Sivex.Models.Espacios.BeanEspacios;
import com.edu.utez.Sivex.Models.Eventos.BeanEventos;
import com.edu.utez.Sivex.Models.rol.RolBean;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuario")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BeanUsuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    @Column(length = 100,nullable = false)
    private String correo;
    @Column(length = 100, nullable= false)
    private String password;
    @Column(columnDefinition = "BOOL DEFAULT true")
    private Boolean status;




    public BeanUsuario(String correo, String password) {
        this.correo = correo;
        this.password = password;

    }

    public BeanUsuario(long id, String correo, String password, Boolean status, Set<RolBean> roles) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.status = true;
        this.roles = roles;
    }

    public BeanUsuario(long id, String correo, String password, Boolean status) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.status = true;
    }

    @ManyToMany(mappedBy = "users", cascade = CascadeType.MERGE)
    private Set<RolBean> roles;

    @OneToMany(mappedBy = "beanUsuario")
    private Set<BeanEspacios> beanEspacios;

    @ManyToMany
    @JoinTable(name = "EventosUsuarios",joinColumns=@JoinColumn(name = "usuarios_id"), inverseJoinColumns = @JoinColumn(name = "eventos_id"))
    Set<BeanEventos>beanEventos=new HashSet<>();
}
