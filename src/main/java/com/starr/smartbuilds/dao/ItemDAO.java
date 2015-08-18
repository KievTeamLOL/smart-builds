/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.Item;
import java.util.List;

/**
 *
 * @author Tanya
 */
public interface ItemDAO {

    public void addItem(Item item);

    public List<Item> listItems();

    public void removeItem(Item item);

    public Item getItem(Integer id);
}


