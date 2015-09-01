/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.service;

import com.starr.smartbuilds.dao.BuildDAO;
import com.starr.smartbuilds.dao.ItemDAO;
import com.starr.smartbuilds.entity.Build;
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
    
   public String buildData(Build build, List<Block> blocks) {
        JSONObject json_build = new JSONObject();
        json_build.put("title", build.getName());
        json_build.put("type", "custom");
        json_build.put("map", "SR");
        json_build.put("mode", "any");
        json_build.put("type", "custom");
        JSONArray json_blocks = new JSONArray();
        for (Block block:blocks){
             JSONObject json_block = new JSONObject();
             json_block.put("type", block.getName());
             JSONArray json_items = new JSONArray();
             for(Item item:block.getItems()){
                 JSONObject json_item = new JSONObject();
                 json_item.put("id", item.getId()+"");
                 json_item.put("count", 1);
                 json_items.add(json_item);
             }
             json_block.put("items", json_items);
             json_blocks.add(json_block);
        }
        json_build.put("blocks", json_blocks);
   
        return json_build.toString();
    }
    
    
}
