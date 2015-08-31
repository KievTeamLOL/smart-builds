/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.Category;
import java.util.List;

/**
 *
 * @author Tanya
 */
public interface CategoryDAO {
    public void addCategory(Category category);

    public List<Category> listCategories();

    public void removeCategory(Category category);

    public Category getCategory(Integer id);
}
