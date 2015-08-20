/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.ItemDAO;
import com.starr.smartbuilds.dao.TagDAO;
import com.starr.smartbuilds.entity.Item;
import com.starr.smartbuilds.entity.Tag;
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
public class AddController {
     @Autowired
    private ItemDAO itemDAO;
    
    @Autowired
    private TagDAO tagDAO;
    
    private DataService dataService = new DataService();

    @RequestMapping(method = {RequestMethod.GET})
    public String getItems(Model model) throws IOException, ParseException {

        List<Tag> tags = tagDAO.listTags();
        if (tags.size() == 0) {
            dataService.getDataFromRiotAPI();
            tags = tagDAO.listTags();
        }
        model.addAttribute("tags", tags);
        return "add";
    }
}
