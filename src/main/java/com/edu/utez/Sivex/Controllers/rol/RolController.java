package com.edu.utez.Sivex.Controllers.rol;

import com.edu.utez.Sivex.Controllers.rol.dto.rolDTO;
import com.edu.utez.Sivex.Service.rol.RolService;
import com.edu.utez.Sivex.config.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sivex/rol")
@CrossOrigin(origins = {"*"})
public class RolController {

    private final RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> findRoles(){
        return service.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findRol(@PathVariable("id") Long Idrol){
        return service.finOneId(Idrol);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> saveRol(@RequestBody rolDTO dto){

        return service.save(dto.toEntity());
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse> updateRol(@RequestBody rolDTO dto){
        return service.update(dto.toUpdate());
    }

}
