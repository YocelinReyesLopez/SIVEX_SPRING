package com.edu.utez.Sivex.Controllers.Servicios;

import com.edu.utez.Sivex.Controllers.Servicios.dto.ServiciosDto;
import com.edu.utez.Sivex.Service.Servicios.ServicesExtra;
import com.edu.utez.Sivex.config.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Sivex/servicios")
@CrossOrigin(origins = "http://localhost:5173/")
@AllArgsConstructor
public class ServiciosController {
    private ServicesExtra service;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@RequestBody ServiciosDto dto) {
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
    public ResponseEntity<ApiResponse> Actualizar(@PathVariable Long id, @RequestBody ServiciosDto dto) {
        return service.Update(id, dto.toEntity());
    }
}