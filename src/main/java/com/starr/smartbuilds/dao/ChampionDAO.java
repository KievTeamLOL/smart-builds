/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.Champion;
import java.util.List;

/**
 *
 * @author Tanya
 */
public interface ChampionDAO {
    public void addChampion(Champion champion);

    public List<Champion> listChampions();

    public void removeChampion(Champion champion);

    public Champion getChampion(Long id);
    
    public void updateChampion(Champion  champion);
}
