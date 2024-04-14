package com.edu.utez.Sivex.Controllers.Eventos;

import com.edu.utez.Sivex.Controllers.Eventos.Dto.EventosDto;
import com.edu.utez.Sivex.Controllers.Usuario.dto.UsuarioDto;
import com.edu.utez.Sivex.Service.Eventos.EventosService;
import com.edu.utez.Sivex.config.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/Sivex/eventos")
@CrossOrigin(origins = "http://localhost:5173/")
@AllArgsConstructor
public class EventosController {

    private EventosService service;
    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@RequestBody EventosDto dto) {
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
    public ResponseEntity<ApiResponse> Actualizar(@PathVariable Long id, @RequestBody EventosDto dto) {
        return service.Update(id, dto.toEntity());
    }
}
