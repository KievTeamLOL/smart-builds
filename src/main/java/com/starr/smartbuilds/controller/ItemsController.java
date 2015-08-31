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
import com.starr.smartbuilds.util.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemDAO itemDAO;
    
    @Autowired
    private TagDAO tagDAO;
    
    @Autowired
    private DataService dataService;

    @RequestMapping(method = {RequestMethod.GET})
    public String getItems(Model model) throws IOException, ParseException {

        List<Item> items = itemDAO.listItems();
        if (items.size() == 0) {
            dataService.getItemsDataFromRiotAPI();
            items = itemDAO.listItems();
        }
        System.out.println("lal= " + items.size());
        model.addAttribute("items", items);
        return "items";
    }

}
