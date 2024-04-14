package com.edu.utez.Sivex.Controllers.auth;

import com.edu.utez.Sivex.Controllers.auth.dto.SignDto;
import com.edu.utez.Sivex.Service.auth.AuthService;
import com.edu.utez.Sivex.config.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173/")
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public ResponseEntity<ApiResponse> signIn(@RequestBody SignDto dto) {
        return service.signIn(dto.getCorreo(), dto.getPassword());
    }
}

