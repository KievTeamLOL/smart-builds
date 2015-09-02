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
    private ChampionDAO championDAO;

    @Autowired
    private BuildDAO buildDAO;

    @RequestMapping(method = {RequestMethod.GET})
    public String getIndex(Model model, HttpServletRequest req) throws IOException, ParseException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("authMsg", "<a href='./auth'>Log in</a>");
            model.addAttribute("exitReg", "<a href='./reg'>Register</a>");
        } else {
            model.addAttribute("authMsg", "Hello," + user.getSummonerName() + "!");
            model.addAttribute("exitReg", "<a href='./auth/exit'>Exit</a>");
            model.addAttribute("createbuild", "<li><a href='./add' style='color: #deff00;'>Create Build</a></li>");
        }
        List<Champion> champions = championDAO.listChampions();
        List<Build> builds = buildDAO.listBuilds();
        List<Build> builds_new = new ArrayList();

        if (builds.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                builds_new.add(builds.get(i));
            }
        } else {
            builds_new = builds;
        }

        model.addAttribute("recent", builds_new);
        model.addAttribute("champions", champions);

        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postIndex(Model model, HttpServletRequest req) {

        return "index";
    }
}
