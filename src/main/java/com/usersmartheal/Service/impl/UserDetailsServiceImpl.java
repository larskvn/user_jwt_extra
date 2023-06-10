package com.usersmartheal.Service.impl;

import com.usersmartheal.Entity.UsuarioEntity;
import com.usersmartheal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        UsuarioEntity  usuarioEntity = usuarioRepository.findByUsername(username);
                //.orElseThrow(()-> new UsernameNotFoundException("El usuario no exite" + username + "no esxite"));
        Collection<? extends GrantedAuthority> authorities = usuarioEntity.getUsuarioRoles()
                .stream()
                .map(role -> new  SimpleGrantedAuthority("ROLE_".concat(role.getRol().getNombre())))
                .collect(Collectors.toSet());


        return new User(usuarioEntity.getUsername(),
                usuarioEntity.getPassword(),
                true,
                true,
                true,
                true,
                authorities);

    }
}
