package com.edu.utez.Sivex.Controllers.Historial;

import com.edu.utez.Sivex.Controllers.Historial.dto.HostorialDto;
import com.edu.utez.Sivex.Controllers.Usuario.dto.UsuarioDto;
import com.edu.utez.Sivex.Service.Historial.ServiceHistorial;
import com.edu.utez.Sivex.config.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Sivex/Historial")
@CrossOrigin(origins = "http://localhost:5173/")
@AllArgsConstructor
public class HisitorialController {
    public ServiceHistorial service;
    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@RequestBody HostorialDto dto) {
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
    public ResponseEntity<ApiResponse> Actualizar(@PathVariable Long id, @RequestBody HostorialDto dto) {
        return service.Update(id, dto.toEntity());
    }
}