package com.edu.utez.Sivex.security.service;

import com.edu.utez.Sivex.Models.Usuario.BeanUsuario;
import com.edu.utez.Sivex.Models.Usuario.UsuarioRepository;
import com.edu.utez.Sivex.Service.Usuario.ServiceUsuario;
import com.edu.utez.Sivex.security.model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ServiceUsuario service;

    public UserDetailsServiceImpl( ServiceUsuario service) {
        this.service = service;
    }
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Optional<BeanUsuario> foundUser = service.findUserByUsername(correo);
        if (foundUser.isPresent())
            return UserDetailsImpl.build(foundUser.get());
        throw new UsernameNotFoundException("UserNotFound");
    }

}
