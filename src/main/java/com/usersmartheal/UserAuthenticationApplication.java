package com.usersmartheal;

import com.usersmartheal.Entity.RolEntity;
import com.usersmartheal.Entity.UserRolEntity;
import com.usersmartheal.Entity.UsuarioEntity;
import com.usersmartheal.Service.UsuarioService;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class UserAuthenticationApplication /* implements CommandLineRunner*/ {

    /*   @Autowired
    private UsuarioService usuarioService;*/
    public static void main(String[] args) {
        SpringApplication.run(UserAuthenticationApplication.class, args);
    }



    /*
    @Override
    public void run(String... args) throws Exception {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUserid(402845l);
        usuario.setUsername("kevin");
        usuario.setLastname("yaringaño");
        usuario.setPassword("123456");
        usuario.setPhone("95211222");
        usuario.setBirthdate(LocalDate.of(1990, 5, 15));
    
        
        RolEntity rolEntity = new RolEntity();
        rolEntity.setRolId(1L);
        rolEntity.setNombre("ADMIN");
        
        
        Set<UserRolEntity> usuarioRoles = new  HashSet<>();
        UserRolEntity usuarioRol = new UserRolEntity();
        usuarioRol.setRol(rolEntity);
        usuarioRol.setUsuario(usuario);
        usuarioRoles.add(usuarioRol);
        
        
        UsuarioEntity usuarioguardado = usuarioService.save(usuario,usuarioRoles);
        System.out.println(usuarioguardado.getUsername());
        
    }*/
    
}
