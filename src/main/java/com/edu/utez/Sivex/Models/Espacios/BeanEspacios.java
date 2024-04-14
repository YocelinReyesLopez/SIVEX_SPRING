package com.edu.utez.Sivex.Models.Espacios;

import com.edu.utez.Sivex.Models.Historial.BeanHistorial;
import com.edu.utez.Sivex.Models.Usuario.BeanUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "espacios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeanEspacios{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 225, nullable = false)
    private String Descripcion;

    public BeanEspacios(String name, String descripcion) {
        this.name = name;
        Descripcion = descripcion;
    }

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "usuario_id")
    private BeanUsuario beanUsuario;
}
