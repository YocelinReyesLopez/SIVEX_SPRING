package com.edu.utez.Sivex.Controllers.Usuario;

import com.edu.utez.Sivex.Controllers.Usuario.dto.UsuarioDto;
import com.edu.utez.Sivex.Service.Usuario.ServiceUsuario;
import com.edu.utez.Sivex.config.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/Sivex/usuario")
@CrossOrigin({"*"})
@AllArgsConstructor
public class UsuarioController {

    public ServiceUsuario service;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@RequestBody UsuarioDto dto) {
        return service.save(dto.toEntity());
    }

    @GetMapping("/Registro")
    public ResponseEntity<ApiResponse> GetAll() {
        return service.GetAll();
    }

    @GetMapping("/Buscar/{id}")
    public ResponseEntity<ApiResponse> buscar(@PathVariable Long id) {
        return service.Buscar(id);
    }

    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<ApiResponse> Actualizar(@PathVariable Long id, @RequestBody UsuarioDto dto) {
        return service.Update(id,dto.toEntity());
    }
}
