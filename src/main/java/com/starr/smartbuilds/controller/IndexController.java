/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.CategoryDAO;
import com.starr.smartbuilds.dao.ChampionDAO;
import com.starr.smartbuilds.dao.ItemDAO;
import com.starr.smartbuilds.dao.TagDAO;
import com.starr.smartbuilds.entity.Champion;
import com.starr.smartbuilds.entity.User;
import com.starr.smartbuilds.service.DataService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/")
public class IndexController {
    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private TagDAO tagDAO;

    @Autowired
    private ChampionDAO championDAO;
    
    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private DataService dataService;

    @RequestMapping(method = {RequestMethod.GET})
    public String getIndex(Model model, HttpServletRequest req) throws IOException, ParseException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            model.addAttribute("authMsg","<a href='./auth'>Log in</a>");
            model.addAttribute("exitReg","<a href='./reg'>Register</a>");
        }else{
            model.addAttribute("authMsg","Hello,"+user.getSummonerName()+"!");
            model.addAttribute("exitReg","<a href='./exit'>Exit</a>");
        }
        List<Champion> champions = championDAO.listChampions();
        List<String> champions_new = new ArrayList<String>();
        for(Champion champ: champions){
            champions_new.add(champ.getName().toLowerCase().replace(" ", "-").replace("'", "").replace(".", ""));
        }
        model.addAttribute("champions", champions_new);
                
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postIndex(Model model, HttpServletRequest req) {

        return "index";
    }
}
