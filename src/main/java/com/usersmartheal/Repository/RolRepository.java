/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usersmartheal.Repository;

import com.usersmartheal.Entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author usuario
 */
public interface RolRepository extends  JpaRepository<RolEntity, Long>{
    
}
