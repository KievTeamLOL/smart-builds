/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.dao;

import com.starr.smartbuilds.entity.Build;
import java.util.List;

/**
 *
 * @author Tanya
 */
public interface BuildDAO {

    public Long addBuild(Build build);

    public List<Build> listBuilds();

    public void removeBuild(Build build);

    public Build getBuild(Long id);
}
