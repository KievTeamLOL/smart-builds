/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.service;

import com.starr.smartbuilds.entity.Build;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tanya
 */
@Service
public class FileService {

    @Autowired
    private BuildService buildService;

    public String getFile(Build build) throws FileNotFoundException, IOException, ParseException {
        
        /*if (fileName == null || fileName.equals("") || fileText == null || fileText.equals("")) {
         resultMsg = "<font color='red'>Fail: File is not created!</font>";
         } else {
         try {*/
        File dir = new File("D:/builds");
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdir();
        }
       
        String fileName = "D:/builds/" + build.getChampion().getKeyChamp() + build.getId() + ".json";
        File fileBuild = new File(fileName);
        if (!fileBuild.exists() || fileBuild.isDirectory()) {
            String file_data = buildService.buildData(build, buildService.parseBlocks(build.getBlocks()));
            FileOutputStream fos = new FileOutputStream(fileBuild, false);
            fos.write(file_data.getBytes());
            fos.close();
        }

        /*} catch (IOException ex) {
         resultMsg = "<font color='red'>Fail: File is not created!</font>";
         }
         }*/
        return fileName;
    }


}
