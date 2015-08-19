/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.Item;
import com.starr.smartbuilds.entity.Tag;
import java.util.List;

/**
 *
 * @author Tanya
 */
public interface TagDAO {

    public void addTag(Tag tag);

    public List<Tag> listTags();

    public void removeTag(Tag tag);

    public Tag getTag(Integer id);
    
    public void updateTag(Tag  tag);
}
