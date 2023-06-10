/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usersmartheal.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="usuarios")
public class UsuarioEntity {

    @Id
    @Column(name = "userid" )
    private int userid;

    private String username;

    private String lastname;

    private String password;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    private String phone;

    private String specialty; // llve foranea en el fututo

    private boolean enable = true;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonIgnore
    private Set<UserRolEntity> usuarioRoles = new HashSet<>();

    /*
    
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public boolean isEnable() {
        return false;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Set<UserRolEntity> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UserRolEntity> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    public UsuarioEntity(Integer userid, String username, String lastname, String password, LocalDate birthdate, String phone, String specialty) {
        this.userid = userid;
        this.username = username;
        this.lastname = lastname;
        this.password = password;
        this.birthdate = birthdate;
        this.phone = phone;
        this.specialty = specialty;
    }

    public UsuarioEntity() {
    }
*/
    
    
}
