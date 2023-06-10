/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersmartheal.Service.impl;

import com.usersmartheal.Entity.UserRolEntity;
import com.usersmartheal.Entity.UsuarioEntity;
import com.usersmartheal.Model.Resultados;
import com.usersmartheal.Model.Valoracion;
import com.usersmartheal.Repository.RolRepository;
import com.usersmartheal.Repository.UsuarioRepository;
import com.usersmartheal.Service.UsuarioService;

import java.util.*;

import com.usersmartheal.feignClients.ResultadoFeignClient;
import com.usersmartheal.feignClients.ValoracionFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioServiceImp implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepositorio;
    
    @Autowired
    private RolRepository rolRepositorio;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResultadoFeignClient resultadoFeignClient;

    @Autowired
    private ValoracionFeignClient valoracionFeignClient;


    @Override
    public UsuarioEntity save(UsuarioEntity usuario, Set<UserRolEntity> usuarioRoles) throws Exception {
        UsuarioEntity usuarioLocal = usuarioRepositorio.findByUsername(usuario.getLastname());
        if(usuarioLocal !=null){
            System.out.println("user ya exite");
            throw new Exception("user ya esta presente");
        }
        else{
            for(UserRolEntity usuarioRol:usuarioRoles){
                rolRepositorio.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal=usuarioRepositorio.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public UsuarioEntity obtenerUser(String username) {
        return usuarioRepositorio.findByUsername(username);
    }


    //integrado
    @Override
    public UsuarioEntity getUsuarioById(int userid) {
       return usuarioRepositorio.findById(userid).orElse(null);
    }

    @Override
    public void delete(int usuarioId) {
        usuarioRepositorio.deleteById(usuarioId);
    }


    //conexion rest
    @Override
    public List<Resultados> getResultado(int idUser) {
        List<Resultados> resultados = restTemplate.getForObject("http://localhost:8002/resultado/byuser/" + idUser, List.class);
        return resultados;
    }

    @Override
    public List<Valoracion> getValoracion(int medicId) {
        List<Valoracion> valoracions = restTemplate.getForObject("http://localhost:8004/valoracion/byuser/" + medicId, List.class);
        return valoracions;
    }



    // feign client
    @Override
    public Resultados saveResult(int userId, Resultados r) {
            r.setIdUser(userId);
            Resultados resultadosNew = resultadoFeignClient.add(r);
            return resultadosNew;

    }

    @Override
    public Map<String, Object> getUserResult(int idUser) {
        Map<String, Object> result = new HashMap<>();
        UsuarioEntity usuarioEntity = usuarioRepositorio.findById(idUser).orElse(null);
        if (usuarioEntity == null){
            result.put("Mensaje","no exite el usuario");
            return result;
        }
        result.put("User", idUser);
        List<Resultados> resultados = resultadoFeignClient.getResult(idUser);
        if (resultados.isEmpty())
            result.put("Resultado"," ese usuario no tiene resultados disponibles");
        else
            result.put("Resultados", resultados);
        return result;
    }


    @Override
    public Valoracion saveValid(int medicId, Valoracion v) {
        v.setMedicId(medicId);
        Valoracion valoracionNew = valoracionFeignClient.add(v);
        return valoracionNew;
    }






   /* @Override
    public UsuarioEntity getUsuarioById(long id) {
        return usuarioRepositorio.findByUserId(id);
    }*/

    /*@Override
    public List<UsuarioEntity> findByUserId(int userid) {
        return usuarioRepositorio.findByUserId(userid);
    }*/







}
