package com.edu.utez.Sivex.Models.rol;

import com.edu.utez.Sivex.Models.Usuario.BeanUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "rol")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolBean {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idROl;
    @Column(length = 100, nullable = false)
    private String rol;

    public RolBean(Long idRol, String rol) {
        this.idROl = idRol;
        this.rol = rol;
    }

    public RolBean( String rol) {
        this.rol = rol;
    }



    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )

    private Set<BeanUsuario> users;


}
