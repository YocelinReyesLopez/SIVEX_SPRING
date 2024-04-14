package com.edu.utez.Sivex.Controllers.Historial.dto;

import com.edu.utez.Sivex.Models.Historial.BeanHistorial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HostorialDto {
    private long id;
    private LocalDate fecha;
    private Double precio;

    public BeanHistorial toEntity(){
        return new BeanHistorial( fecha, precio);
    }
}
