/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.service.AuthService;
import com.starr.smartbuilds.service.FileService;
import com.starr.smartbuilds.service.RegService;
import java.io.IOException;
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
@RequestMapping("/facebook")
public class FacebookController {
  
    @Autowired
    private RegService regService;

    @RequestMapping(method = {RequestMethod.GET})
    public void getFace(Model model) {
        model.addAttribute("file", new FileService());
        //return "facebook";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public void addFace(@ModelAttribute("file") FileService file, Model model) throws IOException {
        String result = file.writeFile();  
        model.addAttribute("result", result);
       // return "facebook";
    }
}
