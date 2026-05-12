package com.cristian.restaurante_api.security;

import com.cristian.restaurante_api.model.Usuario;
import com.cristian.restaurante_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(
            String cedula
    ) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository
                .findByCedula(cedula)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Usuario no encontrado"
                        )
                );

        return new User(
                usuario.getCedula(),
                usuario.getPassword(),
                List.of(
                        new SimpleGrantedAuthority(
                                "ROLE_" +
                                        usuario.getRol().name()
                        )
                )
        );
    }
}