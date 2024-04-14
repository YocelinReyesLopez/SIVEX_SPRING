package com.edu.utez.Sivex.Controllers.Espacios.dto;

import com.edu.utez.Sivex.Models.Espacios.BeanEspacios;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspaciosDto {
    private long id;
    private String name;
    private String Descripcion;

    public BeanEspacios toEntity(){
        return new BeanEspacios(name,Descripcion);
    }
}
