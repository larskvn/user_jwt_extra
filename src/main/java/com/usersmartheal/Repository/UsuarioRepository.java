/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usersmartheal.Repository;

import com.usersmartheal.Entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author usuario
 */
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{


    /*@Query("SELECT r FROM Resultado r WHERE r.userid = :userid")
    List<UsuarioEntity> findByUserId(@Param("userid") Long userid);*/

    public  UsuarioEntity findByUsername(String username);

    //Optional<UsuarioEntity> findByUsername(String username);

    
    Optional<UsuarioEntity> findOneByUserid(Long userid);
}
