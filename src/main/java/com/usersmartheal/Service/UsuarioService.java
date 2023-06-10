/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usersmartheal.Service;

import com.usersmartheal.Entity.UserRolEntity;
import com.usersmartheal.Entity.UsuarioEntity;
import com.usersmartheal.Model.Resultados;
import com.usersmartheal.Model.Valoracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author usuario
 */
public interface UsuarioService {

    public UsuarioEntity save(UsuarioEntity usuario, Set<UserRolEntity> usuarioRoles) throws  Exception;
    
    public  UsuarioEntity obtenerUser(String username);

    //integrado
    public UsuarioEntity getUsuarioById(int userid);


    public  void delete(int usuarioId);


    //implementado
    List<Resultados> getResultado(int idUser);

    List<Valoracion> getValoracion(int medicId);

    public Resultados saveResult(int userId, Resultados r);

    public Map<String, Object> getUserResult(int idUser);



    public Valoracion saveValid(int medicId, Valoracion v);




}
