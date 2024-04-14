package com.edu.utez.Sivex.Controllers.Servicios.dto;

import com.edu.utez.Sivex.Models.Servicios.BeanServicios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiciosDto {
    public long id;
    public String nombre;

    public BeanServicios toEntity(){
        return new BeanServicios(nombre);
    }
}
