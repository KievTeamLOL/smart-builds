/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.UserDAO;
import com.starr.smartbuilds.entity.User;
import com.starr.smartbuilds.service.AuthService;
import com.starr.smartbuilds.service.RegService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    
    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = {RequestMethod.GET})
    public String getAuth(Model model,HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            model.addAttribute("authMsg","<a href='./auth'>Log in</a>");
            model.addAttribute("exitReg","<a href='./reg'>Register</a>");
        }else{
            resp.sendRedirect("./");
        }
        model.addAttribute("auth", new AuthService());
        return "authorization";
    }
    
    @RequestMapping(method = {RequestMethod.GET}, value="/exit")
    public void getExit(Model model,HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.setAttribute("user", null);
        resp.sendRedirect("../");
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String addUser(@ModelAttribute("auth") AuthService auth, Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = auth.checkAuth(userDAO);
        HttpSession session = req.getSession();
        if(user!=null){ //вернуть юзера
            session.setAttribute("user", user);
            resp.sendRedirect("./");
        }else {
            model.addAttribute("authMsg","<a href='./auth'>Log in</a>");
            model.addAttribute("exitReg","<a href='./reg'>Register</a>");
            model.addAttribute("result", "<font color='red'><b>Wrong email or password!</b></font>");
        }
         return "authorization";
       
    }
}
