/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.BuildDAO;
import com.starr.smartbuilds.entity.Build;
import com.starr.smartbuilds.service.BuildService;
import com.starr.smartbuilds.service.FileService;
import com.starr.smartbuilds.service.RegService;
import java.io.IOException;
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
@RequestMapping("/facebook")
public class FacebookController {
  
    @Autowired
    private RegService regService;
    
      @Autowired
    private BuildDAO buildDAO;

    @Autowired
    private BuildService buildService;

    @Autowired
    private FileService fileService;

    @RequestMapping(method = {RequestMethod.GET})
    public void getFace(Model model) throws ParseException {
        
               // Build build = buildDAO.getBuild(2L);
        // model.addAttribute("blocks", buildService.parseBlocks(build.getBlocks()));
        //return "facebook";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public void addFace(@ModelAttribute("file") FileService file, Model model) throws IOException {
      //  String result = file.writeFile();  
      //  model.addAttribute("result", result);
       // return "facebook";
    }
}
