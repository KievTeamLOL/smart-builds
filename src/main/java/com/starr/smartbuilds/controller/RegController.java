/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.ChampionDAO;
import com.starr.smartbuilds.dao.UserDAO;
import com.starr.smartbuilds.entity.User;
import com.starr.smartbuilds.service.DataService;
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
public class RegController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ChampionDAO championDAO;

    @Autowired
    private DataService dataService;

    @RequestMapping(method = {RequestMethod.GET})
    public String getAuth(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String addUser(@ModelAttribute("user") User user, Model model) {
        user.setSummonerID(4L);
        user.setTier("silver");
        userDAO.addUser(user);
        model.addAttribute("result", "done:");
        return "reg";
    }
}
