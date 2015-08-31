/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.ChampionDAO;
import com.starr.smartbuilds.dao.UserDAO;
import com.starr.smartbuilds.entity.User;
import com.starr.smartbuilds.service.AuthService;
import com.starr.smartbuilds.service.RegService;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tanya
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private RegService regService;

    @RequestMapping(method = {RequestMethod.GET})
    public String getAuth(Model model) {
        model.addAttribute("auth", new AuthService());
        return "auth";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String addUser(@ModelAttribute("auth") AuthService auth, Model model) {
        if(auth.checkAuth()){
            model.addAttribute("result", "done");
        }else {
             model.addAttribute("result", "fail");
        }
        return "auth";
    }
}
