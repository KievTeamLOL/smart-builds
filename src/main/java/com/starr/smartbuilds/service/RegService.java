/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.service;

import com.starr.smartbuilds.dao.UserDAO;
import com.starr.smartbuilds.entity.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
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
    
     @Autowired
    private DataService dataService;

    public String registerUser(User user) throws IOException, ParseException {
        String message;
        try {
            Long SummonerID = dataService.getSummonerIdFromData(user.getRegion(),user.getSummonerName());
            user.setSummonerID(SummonerID);
            String tier = dataService.getSummonerTierFromData(user.getRegion(), SummonerID);
            user.setTier(tier);
            userDAO.addUser(user);
            message = "<font color='green'>Done: Account succesfully registered! You can now log in.</font>";
        } catch (javax.validation.ConstraintViolationException v1_ex) {
            message = "<font color='red'>Failed: Problems with data validation! </font>";
        } catch (org.hibernate.exception.ConstraintViolationException v2_ex) {
            message = "<font color='red'>Failed: Problems with data validation! Perhaps a similar account already exists!</font>";
        }catch (FileNotFoundException f_ex){
            message = "<font color='red'>Failed: Summoner data incorrect!</font>";
        }catch (Exception ex){
            message = "<font color='red'>Failed: Unknown problem:"+ex.getMessage()+"! Please contact administration!</font>";
        }
        
        return message;
    }
    
    private Long getSummonerID(User user){
        Long id = null;
        try{
            id = dataService.getSummonerIdFromData(user.getRegion(),user.getSummonerName());
        } catch (Exception ex){
            
        }
        return id;
    }
}
