/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Tanya
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(name = "summonerID")
    @NotNull
    private Long summonerID;
   
    @Column(name = "region")
    @NotNull
    private String region;

    @Column(name = "tier")
    @NotNull
    private String tier;
    
    @Column(name = "summonerName")
    @NotNull
    private String summonerName;
    
    @Column(name = "password")
    @NotNull
    @Size(min = 6, max = 16)
    private String password;
    
    @Column(name = "email", unique = true)
    @NotNull
    @Email
    @Size(min = 5, max = 64)
    private String email;

    public long getId() {
        return id;
    }

    public Long getSummonerID() {
        return summonerID;
    }

    public void setSummonerID(Long summonerID) {
        this.summonerID = summonerID;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
