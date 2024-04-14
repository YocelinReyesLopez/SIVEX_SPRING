package com.edu.utez.Sivex.Service.auth;

import com.edu.utez.Sivex.Models.Usuario.BeanUsuario;
import com.edu.utez.Sivex.Models.Usuario.UsuarioRepository;
import com.edu.utez.Sivex.Service.Usuario.ServiceUsuario;
import com.edu.utez.Sivex.config.ApiResponse;
import com.edu.utez.Sivex.security.jwt.JwtProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AuthService {
    private final UsuarioRepository  usuarioRepository ;
    private final JwtProvider provider;
    private final AuthenticationManager manager;


    public AuthService(UsuarioRepository usuarioRepository, JwtProvider provider, AuthenticationManager manager) {
        this.usuarioRepository = usuarioRepository;
        this.provider = provider;
        this.manager = manager;
    }

    @Transactional
    public ResponseEntity<ApiResponse> signIn(String correo, String password) {
        try {
            Optional<BeanUsuario> foundUser = usuarioRepository.findBycorreo(correo);
            if (foundUser.isEmpty())
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotFound"), HttpStatus.BAD_REQUEST);
            BeanUsuario user = foundUser.get();
            if (!user.getStatus())
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotEnabled"), HttpStatus.BAD_REQUEST);
            Authentication auth = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(correo, password)
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
            String token = provider.generateToken(auth);

            return new ResponseEntity<>(new ApiResponse(token, HttpStatus.OK,"Token generado"), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "CredentialsMismatch";
            if (e instanceof DisabledException)
                message = "UserDisabled";
            if (e instanceof AccountExpiredException)
                message = "Expiro";
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, message), HttpStatus.UNAUTHORIZED);
        }
    }
}

