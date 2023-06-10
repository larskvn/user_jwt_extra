/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersmartheal.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "roles")
public class RolEntity {

    @Id
    private Long rolId;

    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UserRolEntity> usuarioRoles = new HashSet<>();



    public Long getRolId() {
        return rolId;
    }



    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<UserRolEntity> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UserRolEntity> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    public RolEntity(Long rolId, String nombre) {
        this.rolId = rolId;
        this.nombre = nombre;
    }

    public RolEntity() {
    }

}
