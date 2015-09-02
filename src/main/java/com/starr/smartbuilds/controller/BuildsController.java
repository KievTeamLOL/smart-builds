/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.BuildDAO;
import com.starr.smartbuilds.dao.ChampionDAO;
import com.starr.smartbuilds.entity.Build;
import com.starr.smartbuilds.entity.Champion;
import com.starr.smartbuilds.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/builds")
public class BuildsController {
    
    @Autowired
    private ChampionDAO championDAO;
    
    @Autowired
    private BuildDAO buildDAO;
    
    @RequestMapping(method = {RequestMethod.GET})
    public String getBuild(Model model, HttpServletRequest req, HttpServletResponse resp){
        String champion_p = req.getParameter("champion");
        String lane_p = req.getParameter("lane");
        String role_p = req.getParameter("role");
        String author_p = req.getParameter("author");
        String type_p = req.getParameter("type");

        List<Build> builds = buildDAO.listBuilds();
        
        List<Build> builds_champion = new ArrayList<Build>();
        
        for(Build build:builds){   
         if(champion_p!=null && !champion_p.equals("Any") && !champion_p.equals("")){
             if(build.getChampion().getName().equals(champion_p)){
                 builds_champion.add(build);
             }
         }else{
             builds_champion.add(build);
         }
        }
        
        System.out.println("build champion size:"+builds_champion.size());
        
        List<Build> builds_lane = new ArrayList<Build>();
        
        for(Build build:builds_champion){   
         if(lane_p!=null && !lane_p.equals("Any") && !lane_p.equals("")){
             if(build.getLane().equals(lane_p)){
                 builds_lane.add(build);
             }
         }else{
             builds_lane.add(build);
         }
        }
        
        System.out.println("build lane size:"+builds_lane.size());

          List<Build> builds_role = new ArrayList<Build>();
        
        for(Build build:builds_lane){   
         if(role_p!=null && !role_p.equals("Any") && !role_p.equals("")){
             if(build.getRole().equals(role_p)){
                 builds_role.add(build);
             }
         }else{
             builds_role.add(build);
         }
        }
        
        System.out.println("build role size:"+builds_role.size());
     
       List<Build> builds_author = new ArrayList<Build>();
        
        for(Build build:builds_role){   
         if(author_p!=null && !author_p.equals("Any") && !author_p.equals("")){
             if(build.getUser().getTier().equals(author_p)){
                 builds_author.add(build);
             }
         }else{
             builds_author.add(build);
         }
        }
        
        System.out.println("build author size:"+builds_author.size());
        
        List<Build> builds_type = new ArrayList<Build>();
        
        for(Build build:builds_author){   
         if(type_p!=null && !type_p.equals("Any") && !type_p.equals("")){
             if(build.getType().equals(type_p)){
                 builds_type.add(build);
             }
         }else{
             builds_type.add(build);
         }
        }
        
        System.out.println("build type size:"+builds_type.size());
         
        model.addAttribute("builds",builds_type);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            model.addAttribute("authMsg","<a href='../auth'>Log in</a>");
            model.addAttribute("exitReg","<a href='../reg'>Register</a>");
        }else{
            model.addAttribute("authMsg","Hello,"+user.getSummonerName()+"!");
            model.addAttribute("exitReg","<a href='../auth/exit'>Exit</a>");
            model.addAttribute("createbuild","<li><a href='../add' style='color: #deff00;'>Create Build</a></li>");
        }
        List<Champion> champions = championDAO.listChampions();
        model.addAttribute("champions", champions);
        return "builds";
    }
    
}
