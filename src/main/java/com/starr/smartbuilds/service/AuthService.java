/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.service;

import com.starr.smartbuilds.dao.UserDAO;
import com.starr.smartbuilds.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tanya
 */
@Service
public class AuthService {
    
    private String email;
    private String password;

    public User checkAuth(UserDAO userDAO) {
        User user = userDAO.getUserByEmail(email);
        if (user == null) {
            return null;
        }else {
            if (user.getPassword().equals(password)){
                return user;
            }else {
                return null;
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
