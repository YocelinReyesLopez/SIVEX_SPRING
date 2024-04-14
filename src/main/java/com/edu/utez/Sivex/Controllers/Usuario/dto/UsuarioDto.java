package com.edu.utez.Sivex.Controllers.Usuario.dto;

import com.edu.utez.Sivex.Models.Usuario.BeanUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UsuarioDto {
    private long  id;
    private String correo;
    private String password;
    private String token;

    public BeanUsuario toEntity(){
        return new BeanUsuario(correo,password);
    }
}
