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
import com.starr.smartbuilds.entity.Build;
import com.starr.smartbuilds.entity.Category;
import com.starr.smartbuilds.entity.Champion;
import com.starr.smartbuilds.entity.Tag;
import com.starr.smartbuilds.service.DataService;
import java.io.IOException;
import java.util.List;
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
    private DataService dataService;

    @RequestMapping(method = {RequestMethod.GET})
    public String getItems(Model model) throws IOException, ParseException {
        Build build = new Build();
        build.setName("text");
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
    public String processSubmit(@ModelAttribute("build") Build build,BindingResult result, Model model) {
        System.out.println("------BUILD--------");
        System.out.println("Name:"+build.getName());
        System.out.println("Map:"+build.getMap());
        System.out.println("Role"+build.getRole());
        System.out.println("Lane"+build.getLane());
        System.out.println("Type"+build.getType()); 
        System.out.println("BLOCKS"+build.getBlocks());
         List<Category> categories = categoryDAO.listCategories();
        model.addAttribute("categories", categories);
        List<Tag> tags = tagDAO.listTags();
        model.addAttribute("tags", tags);
        List<Champion> champions = championDAO.listChampions();
        model.addAttribute("champions", champions);
        return "add_build";
    }
}

