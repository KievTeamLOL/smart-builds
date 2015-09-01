/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.BuildDAO;
import com.starr.smartbuilds.dao.CategoryDAO;
import com.starr.smartbuilds.dao.ChampionDAO;
import com.starr.smartbuilds.dao.ItemDAO;
import com.starr.smartbuilds.dao.TagDAO;
import com.starr.smartbuilds.entity.Build;
import com.starr.smartbuilds.entity.Category;
import com.starr.smartbuilds.entity.Champion;
import com.starr.smartbuilds.entity.Tag;
import com.starr.smartbuilds.entity.User;
import com.starr.smartbuilds.service.DataService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tanya
 */
@Controller
@RequestMapping("/add")
public class AddController {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private TagDAO tagDAO;

    @Autowired
    private ChampionDAO championDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private BuildDAO buildDAO;

    @Autowired
    private DataService dataService;

    @RequestMapping(method = {RequestMethod.GET})
    public String getBuilder(Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("./");
        } else {
            model.addAttribute("authMsg", "Hello," + user.getSummonerName() + "!");
            model.addAttribute("exitReg", "<a href='./auth/exit'>Exit</a>");
            model.addAttribute("createbuild", "<li><a href='./add' style='color: #deff00;'>Create Build</a></li>");
        }
        Build build = new Build();
        build.setName("Build name");

        model.addAttribute("build", build);
        List<Category> categories = categoryDAO.listCategories();
        model.addAttribute("categories", categories);
        List<Tag> tags = tagDAO.listTags();
        model.addAttribute("tags", tags);
        List<Champion> champions = championDAO.listChampions();
        model.addAttribute("champions", champions);
        return "add_build";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveBuild(@ModelAttribute("build") Build build, BindingResult result, Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        build.setUser(user);
        build.setSeason("Season V");
        build.setPatch("5.16.1");
        build.setUser(user);

        Long championId = Long.parseLong(req.getParameter("champion"));
        build.setChampion(championDAO.getChampion(championId));

        Long buildId = buildDAO.addBuild(build);
        Build build_new = buildDAO.getBuild(buildId);

        System.out.println("------BUILD--------");
        System.out.println("Name:" + build.getName());
        System.out.println("Map:" + build.getMap());
        System.out.println("Role:" + build.getRole());
        System.out.println("Lane:" + build.getLane());
        System.out.println("Type:" + build.getType());
        System.out.println("BLOCKS" + build.getBlocks());

        resp.sendRedirect("./build?id=" + build_new.getId());

        List<Category> categories = categoryDAO.listCategories();
        model.addAttribute("categories", categories);
        List<Tag> tags = tagDAO.listTags();
        model.addAttribute("tags", tags);
        List<Champion> champions = championDAO.listChampions();
        model.addAttribute("champions", champions);
        model.addAttribute("build", new Build());
        return "add_build";
    }
}
