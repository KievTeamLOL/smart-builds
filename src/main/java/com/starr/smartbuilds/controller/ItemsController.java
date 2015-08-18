/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.controller;

import com.starr.smartbuilds.dao.ItemDAO;
import com.starr.smartbuilds.entity.Item;
import com.starr.smartbuilds.util.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class ItemsController {

    @Autowired
    private ItemDAO itemDAO;

    @RequestMapping(method = {RequestMethod.GET})
    public String getItems(Model model) throws IOException, ParseException {

        List<Item> items = itemDAO.listItems();
        if (items.size() == 0) {
            items = getDataFromRiotAPI();
        }
        System.out.println("lal= " + items.size());
        model.addAttribute("items", items);
        return "items";
    }

    private List<Item> getDataFromRiotAPI() throws IOException, ParseException {
        String line;
        String result = "";
        URL url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/item?itemListData=tags&api_key=" + Constants.API_KEY);
        //Get connection
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("resp:" + responseCode);
        System.out.println("resp msg:" + conn.getResponseMessage());

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.println("BUFFER----");
        while ((line = br.readLine()) != null) {
            result += line;
        }

        conn.disconnect();

        return getItemsFromData(result);
    }

    private List<Item> getItemsFromData(String data) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(data);
        JSONObject json_data = (JSONObject) json.get("data");
        List<Item> items = new ArrayList<Item>();

        for (Object arr : json_data.values()) {
            JSONObject json_arr = (JSONObject) arr;
            Long id = (Long) json_arr.get("id");
            String description = (String) json_arr.get("description");
            String plaintext = (String) json_arr.get("plaintext");
            String name = (String) json_arr.get("name");
            JSONArray json_tags = (JSONArray) json_arr.get("tags");
            System.out.println("tags:" + json_tags);
            String tags = "";
            if (json_tags != null) {
                for (Object tag : json_tags) {
                    tags += (String) tag + "\n";
                }
            }
            Item item = new Item();
            item.setId(id);
            item.setDescription(description);
            item.setName(name);
            item.setPlaintext(plaintext);
            item.setTags(tags);
            items.add(item);
        }
        return items;
    }

}
