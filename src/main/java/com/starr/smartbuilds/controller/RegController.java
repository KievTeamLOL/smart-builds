/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.entity.User;
import com.starr.smartbuilds.service.RegService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public String getReg(Model model,  HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            model.addAttribute("authMsg","<a href='../auth'>Log in</a>");
            model.addAttribute("exitReg","<a href='../reg'>Register</a>");
        }else{
            resp.sendRedirect("../");
        }
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String regUser(@ModelAttribute("user") User user, Model model,  HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {
        HttpSession session = req.getSession();
        User userr = (User) session.getAttribute("user");
        if(userr==null){
            model.addAttribute("authMsg","<a href='../auth'>Log in</a>");
            model.addAttribute("exitReg","<a href='../reg'>Register</a>");
        }else{
            resp.sendRedirect("./");
        }
        String regMsg = regService.registerUser(user);
        model.addAttribute("user", new User());
        model.addAttribute("result", regMsg);
        return "register";
    }
}
