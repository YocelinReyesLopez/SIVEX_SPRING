package com.edu.utez.Sivex.Controllers.Espacios;

import com.edu.utez.Sivex.Controllers.Espacios.dto.EspaciosDto;
import com.edu.utez.Sivex.Service.Espacios.ServiceEspacios;
import com.edu.utez.Sivex.config.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Sivex/espacios")
@CrossOrigin(origins = "http://localhost:5173/")
@AllArgsConstructor
public class ControllerEspacios {

    private ServiceEspacios service;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@RequestBody EspaciosDto dto){
        return service.save(dto.toEntity());
    }

    @GetMapping("/Registro")
    public ResponseEntity<ApiResponse>GetAll(){
        return service.GetAll();
    }

    @GetMapping("/Buscar/{id}")
    public ResponseEntity<ApiResponse>buscar(@PathVariable Long id){
        return service.Buscar(id);
    }

    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<ApiResponse>Actualizar(@PathVariable Long id, @RequestBody EspaciosDto dto){
        return service.Update(id,dto.toEntity());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse>delete(@PathVariable Long id){
        return service.Delete(id);
    }
}
