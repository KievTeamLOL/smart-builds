/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tanya
 */
@Controller
public class OtherController {
    
    @RequestMapping(value="/contacts",method = {RequestMethod.GET})
    public String getContacts(Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            model.addAttribute("authMsg","<a href='./auth'>Log in</a>");
            model.addAttribute("exitReg","<a href='./reg'>Register</a>");
        }else{
            model.addAttribute("authMsg","Hello,"+user.getSummonerName()+"!");
            model.addAttribute("exitReg","<a href='./auth/exit'>Exit</a>");
            model.addAttribute("createbuild","<li><a href='./add' style='color: #deff00;'>Create Build</a></li>");
        }
        return "contacts";
    }
    
      @RequestMapping(value="/about",method = {RequestMethod.GET})
    public String getAbout(Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            model.addAttribute("authMsg","<a href='./auth'>Log in</a>");
            model.addAttribute("exitReg","<a href='./reg'>Register</a>");
        }else{
            model.addAttribute("authMsg","Hello,"+user.getSummonerName()+"!");
            model.addAttribute("exitReg","<a href='./auth/exit'>Exit</a>");
            model.addAttribute("createbuild","<li><a href='./add' style='color: #deff00;'>Create Build</a></li>");
        }
        return "about";
    }
}
