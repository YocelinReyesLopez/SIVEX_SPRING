package com.edu.utez.Sivex.Controllers.Eventos.Dto;

import com.edu.utez.Sivex.Models.Eventos.BeanEventos;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventosDto {
    //private long  id;
    //private LocalDate fecha;
    private String descripcion;
    private String nombre;

    public BeanEventos toEntity(){
        return new BeanEventos(descripcion,nombre);
    }
}
