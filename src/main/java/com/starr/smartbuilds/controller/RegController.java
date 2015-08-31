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
@RequestMapping("/reg")
public class RegController {

    @Autowired
    private RegService regService;

    @RequestMapping(method = {RequestMethod.GET})
    public String getReg(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String regUser(@ModelAttribute("user") User user, Model model) throws IOException, ParseException {
        String regMsg = regService.registerUser(user);
        model.addAttribute("result", regMsg);
        return "reg";
    }
}
