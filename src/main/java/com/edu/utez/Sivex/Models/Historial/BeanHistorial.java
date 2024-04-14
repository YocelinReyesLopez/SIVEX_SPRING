package com.edu.utez.Sivex.Models.Historial;

import com.edu.utez.Sivex.Models.Espacios.BeanEspacios;
import com.edu.utez.Sivex.Models.Eventos.BeanEventos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "historial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeanHistorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "DATE", nullable=false)
    private LocalDate fecha;
    @Column(nullable = false)
    private Double precio;

    public BeanHistorial(LocalDate fecha, Double precio) {
        this.fecha = fecha;
        this.precio = precio;
    }
    @OneToMany(mappedBy = "beanHistorial")
    private Set<BeanEventos> beanEventos;
}
