/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersmartheal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarioRoles")
public class UserRolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioRolId" )
    private Long usuarioRolId;

    @ManyToOne(fetch = FetchType.EAGER)
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    private RolEntity rol;

// getters and setters
    public Long getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public UserRolEntity(Long usuarioRolId, UsuarioEntity usuario, RolEntity rol) {
        this.usuarioRolId = usuarioRolId;
        this.usuario = usuario;
        this.rol = rol;
    }

    public UserRolEntity() {
    }

}
