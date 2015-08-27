/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.User;
import java.util.List;

/**
 *
 * @author Tanya
 */
public interface UserDAO {

    public void addUser(User user);

    public List<User> listUsers();

    public void removeUser(User user);

    public User getUser(Integer id);
    
    public void updateUser(User  user);
}

