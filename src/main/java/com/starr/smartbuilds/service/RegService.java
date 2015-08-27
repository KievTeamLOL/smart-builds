/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.starr.smartbuilds.dao.UserDAO;
import com.starr.smartbuilds.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tanya
 */
@Service
public class RegService {

    @Autowired
    private UserDAO userDAO;

    public void registerUser(User user) {
        String message;
        try {
            userDAO.addUser(user);
        } catch (javax.validation.ConstraintViolationException v1_ex) {
            message = "<font color='red'>Failed: Problems with data validation!</font>";
        } catch (org.hibernate.exception.ConstraintViolationException v2_ex) {
            message = "<font color='red'>Failed: Problems with data validation! Perhaps a similar account already exists!</font>";
        }
    }
    
    private void checkSummoner(User user){
        
    }
}
