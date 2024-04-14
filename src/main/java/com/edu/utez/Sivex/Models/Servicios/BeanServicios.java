package com.edu.utez.Sivex.Models.Servicios;

import com.edu.utez.Sivex.Models.Eventos.BeanEventos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "servicios")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BeanServicios{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    @Column(length = 100, nullable=false)
    public String nombre;

    public BeanServicios(String nombre) {
        this.nombre = nombre;
    }

    @ManyToMany
    @JoinTable(name = "EventosServicios",joinColumns=@JoinColumn(name = "servicios_id"), inverseJoinColumns = @JoinColumn(name = "eventos_id"))
    Set<BeanEventos> beanEventosSet=new HashSet<>();
}
