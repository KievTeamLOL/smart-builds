/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.service;

import com.starr.smartbuilds.dao.BuildDAO;
import com.starr.smartbuilds.dao.ItemDAO;
import com.starr.smartbuilds.entity.Item;
import com.starr.smartbuilds.util.Block;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tanya
 */
@Service
public class BuildService {

    @Autowired
    private BuildDAO buildDAO;

    @Autowired
    private ItemDAO itemDAO;

    public List<Block> parseBlocks(String data) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(data);
        List<Block> blocks = new ArrayList();
        for (Object arr : json.values()) {
            JSONObject json_block = (JSONObject) arr;
            Block block = new Block();
            block.setName((String) json_block.get("name"));
            block.setComment((String) json_block.get("comment"));
            List<Item> items = new ArrayList<Item>();
            JSONArray json_items = (JSONArray) json_block.get("items");
            if (json_items != null) {
                for (Object obj : json_items) {
                    String img = (String) obj;
                    Long imgId = Long.parseLong(img);
                    items.add(itemDAO.getItem(imgId));
                }
            }
            block.setItems(items);
            blocks.add(block);
        }
        return blocks;
    }
    
     public List<Block> getFileJson(String data) throws ParseException {
        
        return null;
    }
    
    
}
