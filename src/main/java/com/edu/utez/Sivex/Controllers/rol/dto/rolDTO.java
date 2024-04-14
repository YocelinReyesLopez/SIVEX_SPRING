package com.edu.utez.Sivex.Controllers.rol.dto;

import com.edu.utez.Sivex.Models.rol.RolBean;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class rolDTO {
    private Long idRol;

    private String rol;
    public RolBean toUpdate(){
        return new RolBean(idRol, rol);
    }

    public RolBean toEntity(){
        return new RolBean(rol);
    }
}
