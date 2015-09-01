/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.ChampionDAO;
import com.starr.smartbuilds.entity.Champion;
import com.starr.smartbuilds.service.DataService;
import java.io.IOException;
import java.util.List;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tanya
 */
@Controller
@RequestMapping("/champs")
public class ChampsController {
      
    @Autowired
    private ChampionDAO championDAO;
    
    @Autowired
    private DataService dataService;

    @RequestMapping(method = {RequestMethod.GET})
    public String getChampions(Model model) throws IOException, ParseException {

       List<Champion> champions = championDAO.listChampions();
        if (champions.isEmpty()) {
            dataService.getChampionsDataFromRiotAPI();
         champions = championDAO.listChampions();
       }
       model.addAttribute("champions", champions);
        return "champions";
    }
}


