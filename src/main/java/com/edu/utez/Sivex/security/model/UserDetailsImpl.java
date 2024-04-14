package com.edu.utez.Sivex.security.model;

import com.edu.utez.Sivex.Models.Usuario.BeanUsuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails{
    private String correo;
    private String password;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String correo, String password, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this.correo= correo;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(BeanUsuario correo){
        Set<GrantedAuthority> authorities =
                correo.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRol()))
                        .collect(Collectors.toSet());
        return new UserDetailsImpl(
                correo.getCorreo(), correo.getPassword(),
                 correo.getStatus() , authorities
        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
