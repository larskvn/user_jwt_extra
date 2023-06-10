/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersmartheal.Controller;

import com.usersmartheal.Entity.RolEntity;
import com.usersmartheal.Entity.UserRolEntity;
import com.usersmartheal.Entity.UsuarioEntity;
import com.usersmartheal.Model.Resultados;
import com.usersmartheal.Model.Valoracion;
import com.usersmartheal.Service.UsuarioService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @PostMapping("/")
    public UsuarioEntity save(@RequestBody UsuarioEntity usuario) throws Exception{
        usuario.setPassword(this.passwordEncoder.encode(usuario.getPassword()));
        Set<UserRolEntity> usuarioRoles = new HashSet<>();
        
        RolEntity rol= new  RolEntity();
        rol.setRolId(2L);
        rol.setNombre("PACIENTE");
        
        UserRolEntity usuarioRol = new UserRolEntity();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        usuarioRoles.add(usuarioRol);
        
        return usuarioService.save(usuario,usuarioRoles);
    }
    @GetMapping("/{username}")
    public UsuarioEntity obtenerUser(@PathVariable("username") String username){
        return usuarioService.obtenerUser(username);

    }

    //integrado

    @GetMapping("/id/{userid}")
    public ResponseEntity<UsuarioEntity> obtenerUsuario(@PathVariable("userid") int userid){
        UsuarioEntity usuarioEntity = usuarioService.getUsuarioById(userid);
        if (usuarioEntity == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEntity);
    }


    @DeleteMapping("/{userid}")
    public void delete(@PathVariable("userId") int userId){
        usuarioService.delete(userId);
    }


    //de conexion

    @GetMapping("/resultado/{idUser}")
    public ResponseEntity<List<Resultados>> getResultados(@PathVariable("idUser") int userid){
        UsuarioEntity usuarioEntity= usuarioService.getUsuarioById(userid);
        if (usuarioEntity == null){
            return ResponseEntity.notFound().build();
        }
        List<Resultados> resultados = usuarioService.getResultado(userid);
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/valoracion/{medicId}")
    public ResponseEntity<List<Valoracion>> getValoracion(@PathVariable("medicId") int userid){
        UsuarioEntity usuarioEntity= usuarioService.getUsuarioById(userid);
        if (usuarioEntity == null){
            return ResponseEntity.notFound().build();
        }
        List<Valoracion> valoracions = usuarioService.getValoracion(userid);
        return ResponseEntity.ok(valoracions);
    }

    // user directo a su resultado

    @GetMapping("/getAllResult/{idUser}")
    public ResponseEntity<Map<String, Object>> getUserResult(@PathVariable("idUser") int idUser){
        Map<String, Object> result = usuarioService.getUserResult(idUser);
        return ResponseEntity.ok(result);

    }

    @PostMapping("/saveResult/{userId}")
    public ResponseEntity<Resultados> saveResult(@PathVariable("userId") int userId, @RequestBody Resultados r){
        if (usuarioService.getUsuarioById(userId) == null)
            return ResponseEntity.notFound().build();
        Resultados resultadosNew = usuarioService.saveResult(userId, r);
        return ResponseEntity.ok(r);
    }



    @PostMapping("/saveValid/{medicId}")
    public ResponseEntity<Valoracion> saveValid(@PathVariable("medicId") int medicId, @RequestBody Valoracion v){
        if (usuarioService.getUsuarioById(medicId) == null)
            return ResponseEntity.notFound().build();
        Valoracion valoracionNew = usuarioService.saveValid(medicId, v);
        return ResponseEntity.ok(v);
    }



    
    
}
