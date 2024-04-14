package com.edu.utez.Sivex.Models.Eventos;

import com.edu.utez.Sivex.Models.Historial.BeanHistorial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "eventos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BeanEventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    @Column(columnDefinition = "DATE", nullable=false)
    private LocalDate fecha;
    @Column(length = 225, nullable = false)
    private String descripcion;
    @Column(length = 225, nullable = false)
    private String nombre;

    /*public BeanEventos(LocalDate fecha, String descripcion, String nombre) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }*/

    public BeanEventos(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "historial_id")
    private BeanHistorial beanHistorial;
}
