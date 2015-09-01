/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.util;

import com.starr.smartbuilds.entity.Item;
import java.util.List;

/**
 *
 * @author Tanya
 */
public class Block {

    private String name;
    private String comment;
    private List<Item> items;

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public List<Item> getItems() {
        return items;
    }
    
    
}
